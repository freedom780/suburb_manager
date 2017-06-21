package au.com.aupost.suburbmanager.api.services.postcode;

import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.TOTAL_NUMBER_OF_POSTCODES;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import au.com.aupost.suburbmanager.api.services.common.ApiServiceTest;
import au.com.aupost.suburbmanager.model.Suburb;

public class GetPostcodesTest extends ApiServiceTest {

    private static final int FIRST_PAGE_SIZE = PAGE_SIZE;
    private static final int SECOND_PAGE_SIZE = TOTAL_NUMBER_OF_POSTCODES - PAGE_SIZE;

    @Before
    public void setUp() throws Exception {
        buildBaseUrl();
    }

    @Test
    public void retrieveFirstPage() {

        // setup fixture
        String suburbsServiceUrl = buildSuburbsServiceUrl();
        
        // exercise SUT
        ResponseEntity<Resources<Suburb>> entity = template.exchange(suburbsServiceUrl, HttpMethod.GET, null, createTypeReference());

        // verify
        Collection<Suburb> suburbs = entity.getBody().getContent();
        assertThat(suburbs.size(), equalTo(FIRST_PAGE_SIZE));

    }

    @Test
    public void retrieveSecondPage() {

        // setup fixture
        String secondPageUrl = buildSecondPageUrl();
        
        // exercise SUT
        ResponseEntity<Resources<Suburb>> entity = template.exchange(secondPageUrl, HttpMethod.GET, null, createTypeReference());

        // verify
        Collection<Suburb> suburbs = entity.getBody().getContent();
        assertThat(suburbs.size(), equalTo(SECOND_PAGE_SIZE));
    }

    private String buildSecondPageUrl() {
        return buildSuburbsServiceUrl() + "?page=1&size=" + PAGE_SIZE;
    }

    private ParameterizedTypeReference<Resources<Suburb>> createTypeReference() {
        return new ParameterizedTypeReference<Resources<Suburb>>() {
        };
    }

    private String buildSuburbsServiceUrl() {
        return baseUrl.toString() + "postcodes";
    }

}
