package nl.kadaster.sensor.identity;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;

@Entity
public class Identity {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	@NotEmpty
	private String telephoneNumber;

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Code> codes;

	Identity() {
	}

	public Identity(String telephoneNumber, Collection<Code> codes) {
		super();
		this.telephoneNumber = telephoneNumber;
		this.codes = codes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Collection<Code> getCodes() {
		return codes;
	}

	public void setCodes(Collection<Code> codes) {
		this.codes = codes;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("telephoneNumber", telephoneNumber)
				.add("codes", codes)
				.toString();
	}
}
