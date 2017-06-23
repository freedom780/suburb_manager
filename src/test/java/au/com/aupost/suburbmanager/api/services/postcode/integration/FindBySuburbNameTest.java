package au.com.aupost.suburbmanager.api.services.postcode.integration;


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

import au.com.aupost.suburbmanager.model.PostCode;

public class FindBySuburbNameTest extends PostCodeTest {

    private static final String MELBOURNE = "Melbourne";
    private static final int NUMBER_OF_POSTCODES_FOR_MELBOURNE = 29;

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
                UriComponentsBuilder.fromHttpUrl(buildPostcodesServiceUrl() + "/search/findBySuburbName").queryParam("name", MELBOURNE);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        
        // exercise SUT
        ResponseEntity<Resources<PostCode>> response = 
                template.exchange(builder.build().encode().toUri(), HttpMethod.GET, requestEntity, createTypeReference());

        // verify
        int numberOfPostcodes = response.getBody().getContent().size();
        assertThat(numberOfPostcodes, equalTo(NUMBER_OF_POSTCODES_FOR_MELBOURNE));
    }
    
}
