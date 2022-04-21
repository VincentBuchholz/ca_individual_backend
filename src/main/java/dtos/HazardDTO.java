package dtos;

import entities.Hazard;

import java.util.Date;

public class HazardDTO {

    private int id;
    private String type;
    private Date created;
    private AddressDTO addressDTO;

    public HazardDTO(String type, AddressDTO addressDTO) {
        this.type = type;
        this.created = new Date();
        this.addressDTO = addressDTO;
    }

    public HazardDTO(Hazard hazard) {
        this.id = id;
        this.type = hazard.getType();
        this.created = hazard.getCreated();
        this.addressDTO = new AddressDTO(hazard.getAddress());
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
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
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
                ", addressDTO=" + addressDTO +
                '}';
    }
}
