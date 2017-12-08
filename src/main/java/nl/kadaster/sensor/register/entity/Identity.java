package nl.kadaster.sensor.register.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;

import nl.kadaster.sensor.register.model.CodeRegistration;

@Entity
public class Identity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty
	private String telephoneNumber;

	@OneToMany(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Code> codes = new HashSet<>();

	Identity() {
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

	public Set<Code> getCodes() {
		return codes;
	}

	public void setCodes(Set<Code> codes) {
		this.codes = codes;
	}

	public static Identity from(CodeRegistration codeRegistration) {
		Identity identity = new Identity();
		identity.setTelephoneNumber(codeRegistration.getTelephoneNumber());
		codeRegistration.getCodes().stream().forEach(s -> identity.getCodes().add(new Code(s, identity)));
		return identity;

	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("telephoneNumber", telephoneNumber)
				.add("codes", codes.stream().map(c -> c.getValue()))
				.toString();
	}
}
