package cresla.models.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergy extends BaseModule implements EnergyModule{
    private int energyOutput;

    AbstractEnergy(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + " Module - " + super.getId() + "\n" +
                "Energy Output: " + this.energyOutput + "\n";
    }
}
