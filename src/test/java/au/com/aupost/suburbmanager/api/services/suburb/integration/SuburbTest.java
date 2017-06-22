package au.com.aupost.suburbmanager.api.services.suburb.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import au.com.aupost.suburbmanager.api.services.SuburbRepository;
import au.com.aupost.suburbmanager.api.services.common.ApiServiceTest;
import au.com.aupost.suburbmanager.model.Suburb;

public abstract class SuburbTest extends ApiServiceTest {

    @Autowired
    SuburbRepository suburbRepository;
    
    ParameterizedTypeReference<Resources<Suburb>> createTypeReference() {
        return new ParameterizedTypeReference<Resources<Suburb>>() {
        };
    }

    String buildSuburbsServiceUrl() {
        return baseUrl.toString() + "suburbs";
    }

    protected Link getSelfLinkFromCreateResponse(ResponseEntity<Resources<Suburb>> entity) {
        return entity.getBody().getLinks().get(0);
    }

}
