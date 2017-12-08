package nl.kadaster.sensor.register.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;

@Entity
public class Code {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonIgnore
	@OneToOne(mappedBy = "code", cascade = CascadeType.ALL)
	private Sensor sensor;

	@NotEmpty
	@Column(unique = true)
	private String value;

	@Enumerated(EnumType.STRING)
	private Status status = Status.INITIALIZED;

	@JsonIgnore
	@ManyToOne(optional = false)
	private Identity identity;

	Code() {
	}

	public Code(String value, Identity identity) {
		this.value = value;
		this.identity = identity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("sensor", sensor)
				.add("value", value)
				.add("status", status)
				.add("identity", identity.getTelephoneNumber())
				.toString();
	}
}
