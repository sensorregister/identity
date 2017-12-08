package nl.kadaster.sensor.register.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.kadaster.sensor.register.entity.Identity;

@Repository
public interface IdentityRepository extends CrudRepository<Identity, Long> {

	Identity findOneByTelephoneNumber(String telephoneNumber);

	Identity findByCodes_Value(String value);

}
