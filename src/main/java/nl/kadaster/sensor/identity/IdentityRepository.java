package nl.kadaster.sensor.identity;

import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "identities", path = "identities")
public interface IdentityRepository extends PagingAndSortingRepository<Identity, Long> {

	Collection<Identity> findByTelephoneNumber(@Param("telephoneNumber") String telephoneNumber);

	Identity findByCodes_Value(@Param("value") String value);

}
