package dtos;

import entities.Address;

public class AddressDTO {
    private int id;
    private String road;
    private String number;
    private int zip;
    private HazardDTO hazardDTO;

    public AddressDTO(String road, String number, int zip) {
        this.road = road;
        this.number = number;
        this.zip = zip;
    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.road = address.getRoad();
        this.number = address.getNumber();
        this.zip = address.getZipcode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public HazardDTO getHazardDTO() {
        return hazardDTO;
    }

    public void setHazardDTO(HazardDTO hazardDTO) {
        this.hazardDTO = hazardDTO;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", road='" + road + '\'' +
                ", number='" + number + '\'' +
                ", zip=" + zip +
                '}';
    }
}
