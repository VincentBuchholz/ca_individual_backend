package dtos;

import entities.Hazard;

import java.util.Date;

public class HazardDTO {

    private int id;
    private String type;
    private Date created;
    private AddressDTO address;

    public HazardDTO(String type, AddressDTO addressDTO) {
        this.type = type;
        this.created = new Date();
        this.address = addressDTO;
    }

    public HazardDTO(Hazard hazard) {
        this.id = hazard.getId();
        this.type = hazard.getType();
        this.created = hazard.getCreated();
        this.address = new AddressDTO(hazard.getAddress());
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

    public AddressDTO getAddressDTO() {
        return address;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.address = addressDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HazardDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", created=" + created +
                ", addressDTO=" + address +
                '}';
    }
}
