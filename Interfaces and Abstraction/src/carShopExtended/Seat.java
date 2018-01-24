package carShopExtended;

import java.io.Serializable;

public class Seat implements Sellable, Serializable{

    private String countryProduced;
    private String color;
    private String model;
    private Integer horsePower;
    private Double price;

    Seat(  String model,String color, Integer horsePower,String countryProduced,Double price) {
        this.setCountryProduced(countryProduced);
        this.setColor(color);
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setPrice(price);
    }

    public void setPrice(Double price) {
        this.price = price;
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
    public Double getPrice() {
        return this.price;
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
