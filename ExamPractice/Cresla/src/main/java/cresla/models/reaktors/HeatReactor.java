package cresla.models.reaktors;

import cresla.interfaces.Container;

public class HeatReactor extends ReactorImpl {

    private int heatReductionIndex;


    public HeatReactor(int id, Container container, int heatReductionIndex) {
        super(id, container);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {

        long energyOutput = super.getContainer().getTotalEnergyOutput();

        if (this.getTotalHeatAbsorbing()< energyOutput){
            return 0L;
        }

        return energyOutput;

    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.heatReductionIndex + super.getContainer().getTotalHeatAbsorbing();

    }

    @Override
    public String toString() {

        return "HeatReactor - "+ super.getId()+"\n" +
                "Energy Output: "+ this.getTotalEnergyOutput() + "\n" +
                "Heat Absorbing: " + this.getTotalHeatAbsorbing()+"\n" +
                "Modules: "+ super.getModuleCount()+"\n";


    }
}
