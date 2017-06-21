package au.com.aupost.suburbmanager.api.services.postcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import au.com.aupost.suburbmanager.api.services.PostCodeRepository;
import au.com.aupost.suburbmanager.api.services.common.ApiServiceTest;
import au.com.aupost.suburbmanager.model.PostCode;

public abstract class PostCodeTest extends ApiServiceTest {

    @Autowired
    PostCodeRepository postCodeRepository;
    
    ParameterizedTypeReference<Resources<PostCode>> createTypeReference() {
        return new ParameterizedTypeReference<Resources<PostCode>>() {
        };
    }

    String buildPostcodesServiceUrl() {
        return baseUrl.toString() + "postcodes";
    }

    Link getSelfLinkFromCreateResponse(ResponseEntity<Resources<PostCode>> entity) {
        return entity.getBody().getLinks().get(0);
    }

}
