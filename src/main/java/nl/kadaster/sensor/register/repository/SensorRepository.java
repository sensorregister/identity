package nl.kadaster.sensor.register.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nl.kadaster.sensor.register.entity.Sensor;

@Repository
public interface SensorRepository extends CrudRepository<Sensor, Long> {

    	Sensor findOneByCode_Value(@Param("value") String value);

	//	Sensor findOneByCode_ValueAndCode_StatusIs(@Param("value") String value, @Param("status") Status status);
	//
	//	@Projection(name = "withCode", types = Sensor.class)
	//	interface SensorWithCode {
	//
	//		String getName();
	//
	//		String getDescription();
	//
	//		Code getCode();
	//
	//	}
}
