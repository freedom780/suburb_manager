package au.com.aupost.suburbmanager.api.services.postcode;

import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.NEW_POST_CODE;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.ONE_NEWLY_ADDED_POST_CODE;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import au.com.aupost.suburbmanager.model.PostCode;

public class CreatePostcodeTest extends PostCodeTest {

    @Before
    public void setUp() throws Exception {
        buildBaseUrl();
    }

    @Test
    public void createPostcode() throws URISyntaxException {

        // setup fixture
        String suburbsServiceUrl = buildPostcodesServiceUrl();
        RequestEntity<PostCode> requestEntity = RequestEntity.post(new URI(buildPostcodesServiceUrl()))
                .contentType(MediaType.APPLICATION_JSON).body(new PostCode(NEW_POST_CODE));
        long numberOfPostcodesBefore = postCodeRepository.count();

        // exercise SUT
        ResponseEntity<Resources<PostCode>> entity = template.exchange(suburbsServiceUrl, HttpMethod.POST, requestEntity, createTypeReference());
        
        // verify
        Link selfLink = getSelfLinkFromCreateResponse(entity);
        String expectedSelfLink = buildPostcodesServiceUrl() + "/" + (numberOfPostcodesBefore + ONE_NEWLY_ADDED_POST_CODE);
        assertThat(selfLink.getHref(), equalTo(expectedSelfLink));
    }

}
