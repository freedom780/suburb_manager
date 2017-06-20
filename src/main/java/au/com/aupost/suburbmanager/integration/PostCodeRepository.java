package au.com.aupost.suburbmanager.integration;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import au.com.aupost.suburbmanager.model.PostCode;

@RepositoryRestResource(collectionResourceRel = "postcodes", path = "postcodes")
public interface PostCodeRepository extends PagingAndSortingRepository<PostCode, Long>{

    PostCode findByCode(int code);
    
}
