package au.com.aupost.suburbmanager.api.services.oauth;


import static au.com.aupost.suburbmanager.api.security.SecurityConstants.MOBILE_CLIENT_ID;
import static au.com.aupost.suburbmanager.api.security.SecurityConstants.USER_NAME;
import static au.com.aupost.suburbmanager.api.security.SecurityConstants.USER_PASSWORD;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OAuthAccessTokenRetriever {

    private static final String LOCATION_HEADER = "Location";
    private static final String COOKIE_HEADER = "Cookie";
    private static final String SECRET_NOT_NEEDED_FOR_MOBILE_CLIENTS = "";

    public String obtainJwtTokenThroughFullOAuthFlow(String baseUrl) {
        FlowHolder flowHolder = new FlowHolder(baseUrl);
        emulateRedirectToUserAuthorizationPage(flowHolder);
        emulateUserAcceptedAuthorizationPrompt(flowHolder);
        return exchangeAuthorisationCodeForAccessToken(flowHolder);
    }

    private void emulateRedirectToUserAuthorizationPage(FlowHolder flowHolder) {
        TestRestTemplate testTemplate = new TestRestTemplate(USER_NAME, USER_PASSWORD);
        ResponseEntity<String> response = testTemplate.postForEntity(buildUserAuthorizationInteractionUrl(flowHolder), null, String.class);
        flowHolder.setSession(extractSessionId(response));
    }

    private String buildUserAuthorizationInteractionUrl(FlowHolder flowHolder) {
        return flowHolder.getBaseUrl() + 
                String.format("oauth/authorize?response_type=code&client_id=%s&redirect_uri=%s", MOBILE_CLIENT_ID, buildRedirectUrl(flowHolder));
    }

    private String buildRedirectUrl(FlowHolder flowHolder) {
        return flowHolder.getBaseUrl() + "redirectUrl";
    }

    private String extractSessionId(ResponseEntity<String> response) {
        List<String> cookieHeader = response.getHeaders().get("Set-Cookie");
        String jSessionId = cookieHeader.get(0);
        return jSessionId.split(";")[0];
    }
    
    private void emulateUserAcceptedAuthorizationPrompt(FlowHolder flowHolder) {
        TestRestTemplate testTemplate = new TestRestTemplate(USER_NAME, USER_PASSWORD);
        ResponseEntity<String> response = 
                testTemplate.postForEntity(buildUrlForProcessingUserApproval(flowHolder), headersWithSession(flowHolder), String.class);
        flowHolder.setAuthorisationCode(extractAuthorisationCode(response));
    }

    private HttpEntity<?> headersWithSession(FlowHolder flowHolder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(COOKIE_HEADER, flowHolder.getSession());
        return new HttpEntity<>(headers);
    }

    private String extractAuthorisationCode(ResponseEntity<String> response) {
        try {
            String locationHeader = response.getHeaders().get(LOCATION_HEADER).get(0);
            URI locationURI = new URI(locationHeader);
            return locationURI.getQuery().split("=")[1];
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e); 
        }
    }

    private String buildUrlForProcessingUserApproval(FlowHolder flowHolder) {
        return flowHolder.getBaseUrl() + 
                String.format("oauth/authorize?response_type=code&client_id=%s&redirect_uri=%s&user_oauth_approval=true&authorize=Authorize", 
                MOBILE_CLIENT_ID, buildRedirectUrl(flowHolder));
    }

    private String exchangeAuthorisationCodeForAccessToken(FlowHolder flowHolder) {
        TestRestTemplate testTemplate = new TestRestTemplate(MOBILE_CLIENT_ID, SECRET_NOT_NEEDED_FOR_MOBILE_CLIENTS);
        ResponseEntity<String> response = testTemplate.postForEntity(buildUrlForTokenExchangeUrl(flowHolder), noHeaders(), String.class);
        return extractJwtAccessToken(response);
    }

    private String extractJwtAccessToken(ResponseEntity<String> response) {
        try {
            HashMap<?, ?> jwtMap = new ObjectMapper().readValue(response.getBody(), HashMap.class);
            return (String) jwtMap.get("access_token");
        } catch (IOException e) {
            throw new IllegalStateException(e); 
        }
    }

    private String buildUrlForTokenExchangeUrl(FlowHolder flowHolder) {
        return flowHolder.getBaseUrl() + String.format("oauth/token?&grant_type=authorization_code&code=%s&client_id=%s&redirect_uri=%s", 
                flowHolder.getAuthorisationCode(), MOBILE_CLIENT_ID, buildRedirectUrl(flowHolder));
    }

    private HttpEntity<Object> noHeaders() {
        return new HttpEntity<>(new HttpHeaders());
    }
}