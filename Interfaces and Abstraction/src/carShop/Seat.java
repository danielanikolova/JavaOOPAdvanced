package carShop;

import java.io.Serializable;

public class Seat implements Car, Serializable{

    private String countryProduced;
    private String color;
    private String model;
    private Integer horsePower;

    Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.setCountryProduced(countryProduced);
        this.setColor(color);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }

    private void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    private String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }


    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                this.getModel(),
                this.getCountryProduced(),
                Car.TIRES
        );
    }
}
