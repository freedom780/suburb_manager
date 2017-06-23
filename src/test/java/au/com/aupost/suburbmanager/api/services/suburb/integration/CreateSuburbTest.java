package au.com.aupost.suburbmanager.api.services.suburb.integration;


import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.NEW_SUBURB_NAME;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.ONE_NEWLY_ADDED_SUBURB;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import au.com.aupost.suburbmanager.model.State;
import au.com.aupost.suburbmanager.model.Suburb;

public class CreateSuburbTest extends SuburbTest {

    @Before
    public void setUp() throws Exception {
        buildBaseUrl();
    }

    @Test
    public void createSuburb() throws URISyntaxException {

        // setup fixture
        String jwtAccessToken = jwtAccessTokenRetriever.obtainJwtTokenThroughFullOAuthFlow(baseUrl.toString());
        
        String request = "{\"name\": \"" + NEW_SUBURB_NAME + "\", \"state\": \"" + State.VIC + "\", \"postCode\": \"/postcodes/2\"}";

        RequestEntity<String> requestEntity = RequestEntity.post(new URI(buildSuburbsServiceUrl()))
                .header("Authorization", "Bearer " + jwtAccessToken)
                .contentType(MediaType.APPLICATION_JSON).body(request);
        
        long numberOfSuburbsBefore = suburbRepository.count();

        // exercise SUT
        ResponseEntity<Resources<Suburb>> entity = 
                template.exchange(buildSuburbsServiceUrl(), HttpMethod.POST, requestEntity, createTypeReference());

        // verify
        long numberOfSuburbsAfter = suburbRepository.count();
        assertThat(numberOfSuburbsAfter, equalTo(numberOfSuburbsBefore + ONE_NEWLY_ADDED_SUBURB));
        
        Link selfLink = getSelfLinkFromCreateResponse(entity);
        assertTrue(selfLink.getHref().contains(buildSuburbsServiceUrl() + "/"));
    }
    
    @Test
    public void returns409ErrorOnSecondAttemptToCreateTheSameSuburb() throws URISyntaxException {

        // setup fixture
        String jwtAccessToken = jwtAccessTokenRetriever.obtainJwtTokenThroughFullOAuthFlow(baseUrl.toString());

        String request = "{\"name\": \"" + NEW_SUBURB_NAME + "\", \"state\": \"" + State.VIC + "\", \"postCode\": \"/postcodes/1\"}";
        
        RequestEntity<String> requestEntity = RequestEntity.post(new URI(buildSuburbsServiceUrl()))
                .header("Authorization", "Bearer " + jwtAccessToken)
                .contentType(MediaType.APPLICATION_JSON).body(request);

        ResponseEntity<Resources<Suburb>> firstResponse = template.exchange(buildSuburbsServiceUrl(), HttpMethod.POST, requestEntity, createTypeReference());

        // exercise SUT
        ResponseEntity<Resources<Suburb>> secondResponse = template.exchange(buildSuburbsServiceUrl(), HttpMethod.POST, requestEntity, createTypeReference());

        // verify
        assertThat(firstResponse.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(secondResponse.getStatusCode(), equalTo(HttpStatus.CONFLICT));
    }

    @Test
    public void returns400ErrorOnInvalidRequestWithouStateOrTerrotory() throws URISyntaxException {

        // setup fixture
        String jwtAccessToken = jwtAccessTokenRetriever.obtainJwtTokenThroughFullOAuthFlow(baseUrl.toString());

        String requestWithoutStateOrTerritory = "{\"name\": \"" + NEW_SUBURB_NAME + "\", \"postCode\": \"/postcodes/1\"}";
        
        RequestEntity<String> requestEntity = RequestEntity.post(new URI(buildSuburbsServiceUrl()))
                .header("Authorization", "Bearer " + jwtAccessToken)
                .contentType(MediaType.APPLICATION_JSON).body(requestWithoutStateOrTerritory);


        // exercise SUT
        ResponseEntity<Resources<Suburb>> response = template.exchange(buildSuburbsServiceUrl(), HttpMethod.POST, requestEntity, createTypeReference());

        // verify
        assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }
    
    @Test
    public void returns400ErrorOnInvalidRequestWithBlankStateOrTerrotory() throws URISyntaxException {

        // setup fixture
        String jwtAccessToken = jwtAccessTokenRetriever.obtainJwtTokenThroughFullOAuthFlow(baseUrl.toString());

        String requestWithoutStateOrTerritory = "{\"name\": \"" + NEW_SUBURB_NAME + "\", \"state\": \"" + "" + "\", \"postCode\": \"/postcodes/1\"}";
        
        RequestEntity<String> requestEntity = RequestEntity.post(new URI(buildSuburbsServiceUrl()))
                .header("Authorization", "Bearer " + jwtAccessToken)
                .contentType(MediaType.APPLICATION_JSON).body(requestWithoutStateOrTerritory);


        // exercise SUT
        ResponseEntity<Resources<Suburb>> response = template.exchange(buildSuburbsServiceUrl(), HttpMethod.POST, requestEntity, createTypeReference());

        // verify
        assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }


}
