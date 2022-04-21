package dtos;

public class CarDTO {
    private String make;
    private String model;
    private String status;
    private String type;
    private String variant;
    private String model_year;
    private String color;
    private String vin;

    public CarDTO(String make, String model, String status, String type, String variant, String model_year, String color, String vin) {
        this.make = make;
        this.model = model;
        this.status = status;
        this.type = type;
        this.variant = variant;
        this.model_year = model_year;
        this.color = color;
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", variant='" + variant + '\'' +
                ", model_year='" + model_year + '\'' +
                ", color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getModel_year() {
        return model_year;
    }

    public void setModel_year(String model_year) {
        this.model_year = model_year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }


}
