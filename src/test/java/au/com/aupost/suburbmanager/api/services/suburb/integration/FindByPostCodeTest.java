package au.com.aupost.suburbmanager.api.services.suburb.integration;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import au.com.aupost.suburbmanager.model.Suburb;

public class FindByPostCodeTest extends SuburbTest {

    private static final String POST_CODE_3006 = "3006";
    private static final int THREE_SUBURBS_WITH_POST_CODE_3006 = 1;

    @Before
    public void setUp() throws Exception {
        buildBaseUrl();
    }
    
    @Test
    public void findByPostCode() throws URISyntaxException {

        // setup fixture
        String jwtAccessToken = jwtAccessTokenRetriever.obtainJwtTokenThroughFullOAuthFlow(baseUrl.toString());
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtAccessToken);

        UriComponentsBuilder builder = 
                UriComponentsBuilder.fromHttpUrl(buildSuburbsServiceUrl() + "/search/findByPostCode").queryParam("postCode", POST_CODE_3006);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        
        // exercise SUT
        ResponseEntity<Resources<Suburb>> response = 
                template.exchange(builder.build().encode().toUri(), HttpMethod.GET, requestEntity, createTypeReference());

        // verify
        int numberOfSuburbs = response.getBody().getContent().size();
        assertThat(numberOfSuburbs, equalTo(THREE_SUBURBS_WITH_POST_CODE_3006));
    }
    
}
