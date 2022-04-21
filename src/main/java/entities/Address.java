package entities;

import javax.persistence.*;

@Table(name = "address")
@Entity
@NamedQuery(name = "Address.deleteAllRows", query = "DELETE from Address ")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="road")
    private String road;

    @Column(name="number")
    private String number;

    @Column(name = "zipcode")
    private int zipcode;

    @OneToOne(mappedBy = "address")
    private Hazard hazard;

    public Address() {
    }

    public Address(String road, String number, int zipcode) {
        this.road = road;
        this.number = number;
        this.zipcode = zipcode;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public Hazard getHazard() {
        return hazard;
    }

    public void setHazard(Hazard hazard) {
        this.hazard = hazard;
        if(hazard.getAddress() != this){
            hazard.setAddress(this);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", road='" + road + '\'' +
                ", number='" + number + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
