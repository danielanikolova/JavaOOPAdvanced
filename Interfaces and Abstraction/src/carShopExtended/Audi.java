package carShopExtended;

public class Audi implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;
    private String countryProduced;
    private String color;
    private String model;
    private Integer horsePower;

    public Audi(String model,String color, Integer horsePower,String countryProduced,Integer minRentDay, Double pricePerDay) {
        this.setCountryProduced(countryProduced);
        this.setColor(color);
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setMinRentDay(minRentDay);
        this.setPricePerDay(pricePerDay);
    }

    private void setMinRentDay(Integer minRentDay) {
        this.minRentDay = minRentDay;
    }

    private void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
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

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
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

    public String getCountryProduced() {
        return this.countryProduced;
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
