package Ferrari;

public class Ferrari implements Car{

    private String model;
    private String driver;

    Ferrari(String driver) {
        this.model = "488-Spider";
        this.setDriver(driver);
    }

    public String getModel() {
        return this.model;
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }
}
