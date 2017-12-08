package nl.kadaster.sensor.register.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;

import nl.kadaster.sensor.register.model.SensorInfo;

@Entity
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty
	private String name;
	private String description;

	@OneToOne(optional = false)
	private Code code;

	Sensor() {
	}

	public Sensor(Code code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("name", name)
				.add("description", description)
				.add("code", code.getValue())
				.toString();
	}

	public static Sensor from(SensorInfo sensorInfo, Code code) {
		Sensor sensor = new Sensor();
		sensor.setCode(code);
		sensor.setDescription(sensorInfo.getDescription());
		sensor.setName(sensorInfo.getName());
		return sensor;
	}
}
