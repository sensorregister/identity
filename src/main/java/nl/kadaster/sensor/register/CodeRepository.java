package nl.kadaster.sensor.register;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "codes", path = "codes")
public interface CodeRepository extends PagingAndSortingRepository<Code, Long> {

	Code findOneByValue(@Param("value") String value);
}
