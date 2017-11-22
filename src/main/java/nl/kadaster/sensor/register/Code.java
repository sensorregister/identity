package nl.kadaster.sensor.register;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Code {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
    @JoinColumn(name = "sensorId")
	private Sensor sensor;

	@NotEmpty
	@Column(unique = true)
	private String value;

	@Enumerated(EnumType.STRING)
	private Status status = Status.INITIALIZED;

	@ManyToOne
	private Identity identity;

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

    public Identity getIdentity() {
        return identity;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public long getId() {
        return id;
    }
}
