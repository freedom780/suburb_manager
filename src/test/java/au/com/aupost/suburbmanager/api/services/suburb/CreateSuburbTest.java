package au.com.aupost.suburbmanager.api.services.suburb;

import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.NEW_SUBURB_NAME;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.ONE_NEWLY_ADDED_SUBURB;
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

import au.com.aupost.suburbmanager.model.Suburb;

public class CreateSuburbTest extends SuburbTest {

    @Before
    public void setUp() throws Exception {
        buildBaseUrl();
    }

    @Test
    public void createSuburb() throws URISyntaxException {

        // setup fixture
        String suburbsServiceUrl = buildSuburbsServiceUrl();
        String request = "{\"name\": \"" + NEW_SUBURB_NAME + "\", \"postCode\": \"/postcodes/1\"}";
        RequestEntity<String> requestEntity = RequestEntity.post(new URI(buildSuburbsServiceUrl()))
                .contentType(MediaType.APPLICATION_JSON).body(request);
        long numberOfSuburbsBefore = suburbRepository.count();

        // exercise SUT
        ResponseEntity<Resources<Suburb>> entity = template.exchange(suburbsServiceUrl, HttpMethod.POST, requestEntity,
                createTypeReference());

        // verify
        Link selfLink = getSelfLinkFromCreateResponse(entity);
        String expectedSelfLink = buildSuburbsServiceUrl() + "/" + (numberOfSuburbsBefore + ONE_NEWLY_ADDED_SUBURB);
        assertThat(selfLink.getHref(), equalTo(expectedSelfLink));
    }

}
