package nl.kadaster.sensor.register;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sensors", path = "sensors")
public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long> {

    SensorWithCodeValue findOneByCode_ValueAndCode_StatusIs(@Param("value") String value, @Param("status") Status status);


    public static interface SensorWithCodeValue {
        String getName();
        String getDescription();
        CodeValue getCode();

        public static interface CodeValue {
            String getValue();
        }
    }
}
