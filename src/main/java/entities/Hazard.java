package entities;

import javax.persistence.*;
import java.util.Date;

@Table(name = "hazard")
@Entity
public class Hazard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;


    @Column(name = "created")
    private Date created;

    @OneToOne
   private Address address;

    public Hazard() {
    }

    public Hazard(String type) {
        this.type = type;
        this.created = new Date();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if(address.getHazard() != this){
            address.setHazard(this);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
