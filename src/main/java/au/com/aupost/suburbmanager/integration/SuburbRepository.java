package au.com.aupost.suburbmanager.integration;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.ControllerAdvice;

import au.com.aupost.suburbmanager.model.Suburb;

@RepositoryRestResource(collectionResourceRel = "suburbs", path = "suburbs")
public interface SuburbRepository extends PagingAndSortingRepository<Suburb, Long>{

    @Query("from Suburb suburb where suburb.postCode.code = ?1")
    List<Suburb> findByPostCode(int postCode);

}
