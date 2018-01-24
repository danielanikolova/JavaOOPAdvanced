package app.waste_disposal.models.wastes;

import app.waste_disposal.contracts.Waste;


public abstract class BaseWaste implements Waste {

    private String Name;
    private double weight;
    private double volumePerKg;


    protected BaseWaste(String name, double weight, double volumePerKg) {
        Name = name;
        this.weight = weight;
        this.volumePerKg = volumePerKg;

    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
