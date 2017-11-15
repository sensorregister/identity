package nl.kadaster.sensor.identity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Code {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private long identityId;

    @NotEmpty
    @Column(unique = true)
    private String value;

    Code() { }

    public Code(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
