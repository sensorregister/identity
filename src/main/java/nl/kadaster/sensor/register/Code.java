package nl.kadaster.sensor.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Code {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private long sensorId;

	@NotEmpty
	@Column(unique = true)
	private String value;

	@Enumerated(EnumType.STRING)
	private Status status = Status.INITIALIZED;

	Code() {
	}

	public Code(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
