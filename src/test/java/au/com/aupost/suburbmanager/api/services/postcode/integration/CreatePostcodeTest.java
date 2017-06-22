package au.com.aupost.suburbmanager.api.services.postcode.integration;

import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.NEW_POST_CODE_2000;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.NEW_POST_CODE_3136;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.ONE_NEWLY_ADDED_POST_CODE;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail; 

import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import au.com.aupost.suburbmanager.model.PostCode;
import au.com.aupost.suburbmanager.model.PostCodeCategory;

public class CreatePostcodeTest extends PostCodeTest {

    @Before
    public void setUp() throws Exception {
        buildBaseUrl();
    }

    @Test
    public void createsPostcodeOnce() throws URISyntaxException {

        // setup fixture
        String jwtAccessToken = jwtAccessTokenRetriever.obtainJwtTokenThroughFullOAuthFlow(baseUrl.toString());
        
        long numberOfPostcodesBefore = postCodeRepository.count();

        RequestEntity<PostCode> requestEntity = RequestEntity.post(new URI(buildPostcodesServiceUrl()))
                .header("Authorization", "Bearer " + jwtAccessToken)
                .contentType(MediaType.APPLICATION_JSON).body(new PostCode(NEW_POST_CODE_3136, PostCodeCategory.DELIVERY));
                
        // exercise SUT
        ResponseEntity<Resources<PostCode>> entity = template.exchange(buildPostcodesServiceUrl(), HttpMethod.POST, requestEntity, createTypeReference());
        
        // verify
        long numberOfPostcodesAfter = postCodeRepository.count();
        assertThat(numberOfPostcodesAfter, equalTo(numberOfPostcodesBefore + ONE_NEWLY_ADDED_POST_CODE));
        
        Link selfLink = getSelfLinkFromCreateResponse(entity);
        assertTrue(selfLink.getHref().contains(buildPostcodesServiceUrl() + "/"));
    }

    @Test
    public void returns409ErrorOnSecondAttemptToCreateTheSamePostCode() throws URISyntaxException {

        // setup fixture
        String jwtAccessToken = jwtAccessTokenRetriever.obtainJwtTokenThroughFullOAuthFlow(baseUrl.toString());

        RequestEntity<PostCode> requestEntity = RequestEntity.post(new URI(buildPostcodesServiceUrl()))
                .header("Authorization", "Bearer " + jwtAccessToken)
                .contentType(MediaType.APPLICATION_JSON).body(new PostCode(NEW_POST_CODE_2000, PostCodeCategory.DELIVERY));

        ResponseEntity<Resources<PostCode>> firstResponse = template.exchange(buildPostcodesServiceUrl(), HttpMethod.POST, requestEntity, createTypeReference());

        // exercise SUT
        ResponseEntity<Resources<PostCode>> secondResponse = template.exchange(buildPostcodesServiceUrl(), HttpMethod.POST, requestEntity, createTypeReference());

        // verify
        assertThat(firstResponse.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(secondResponse.getStatusCode(), equalTo(HttpStatus.CONFLICT));
    }

}
