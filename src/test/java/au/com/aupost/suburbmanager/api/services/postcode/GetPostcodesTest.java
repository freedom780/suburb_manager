package au.com.aupost.suburbmanager.api.services.postcode;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import au.com.aupost.suburbmanager.model.PostCode;

public class GetPostcodesTest extends PostCodeTest {

    @Before
    public void setUp() throws Exception {
        buildBaseUrl();
    }

    @Test
    public void retrieveFirstPage() {

        // setup fixture
        String postcodesServiceUrl = buildPostcodesServiceUrl();
        
        // exercise SUT
        ResponseEntity<Resources<PostCode>> entity = template.exchange(postcodesServiceUrl, HttpMethod.GET, null, createTypeReference());

        // verify
        Collection<PostCode> postcodes = entity.getBody().getContent();
        assertThat(postcodes.size(), equalTo(PAGE_SIZE));

    }

    @Test
    public void retrieveSecondPage() {

        // setup fixture
        String secondPageUrl = buildSecondPageUrl();
        
        // exercise SUT
        ResponseEntity<Resources<PostCode>> entity = template.exchange(secondPageUrl, HttpMethod.GET, null, createTypeReference());

        // verify
        Collection<PostCode> postCodes = entity.getBody().getContent();
        int numberOfPostcodes = (int) postCodeRepository.count();
        assertThat(postCodes.size(), equalTo(numberOfPostcodes - PAGE_SIZE));
    }

    private String buildSecondPageUrl() {
        return buildPostcodesServiceUrl() + "?page=1&size=" + PAGE_SIZE;
    }



}