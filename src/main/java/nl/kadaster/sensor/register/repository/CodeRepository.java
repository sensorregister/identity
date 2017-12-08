package nl.kadaster.sensor.register.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nl.kadaster.sensor.register.entity.Code;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {

	Code findOneByValue(@Param("value") String value);

}
