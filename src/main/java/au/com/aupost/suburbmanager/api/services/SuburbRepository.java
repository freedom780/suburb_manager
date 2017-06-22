package au.com.aupost.suburbmanager.api.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import au.com.aupost.suburbmanager.model.Suburb;

@RepositoryRestResource(collectionResourceRel = "suburbs", path = "suburbs")
public interface SuburbRepository extends PagingAndSortingRepository<Suburb, Long>{

    @Query("FROM Suburb suburb WHERE suburb.postCode.code = ?1")
    List<Suburb> findByPostCode(@Param("postCode") int postCode);

    @Override
    @PreAuthorize("hasRole('ROLE_USER')")
    <S extends Suburb> S save(S s);
}
