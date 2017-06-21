package au.com.aupost.suburbmanager.api.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import au.com.aupost.suburbmanager.model.PostCode;

@RepositoryRestResource(collectionResourceRel = "postcodes", path = "postcodes")
public interface PostCodeRepository extends PagingAndSortingRepository<PostCode, Long>{

    @Query("SELECT postCode FROM PostCode postCode INNER JOIN postCode.suburbs suburb where suburb.name = ?1")
    List<PostCode> findBySuburbName(@Param("name") String suburbName);

    PostCode findByCode(int code);
    
}