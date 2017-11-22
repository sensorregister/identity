package nl.kadaster.sensor.register;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

@RepositoryRestResource(collectionResourceRel = "sensors", path = "sensors")
public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long> {

    Sensor findOneByCode_ValueAndCode_StatusIs(@Param("value") String value, @Param("status") Status status);


    @Projection(name = "withCode", types = Sensor.class)
    interface SensorWithCode {

        String getName();
        String getDescription();
        Code getCode();

    }
}
