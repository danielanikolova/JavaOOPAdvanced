package cresla.models.reaktors;

import cresla.interfaces.Container;

public class CryoReactor extends ReactorImpl {

    private int cryoProductionIndex;

    public CryoReactor(int id, Container container, int cryoProductionIndex) {
        super(id, container);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getContainer().getTotalEnergyOutput()*cryoProductionIndex;
        if (result> this.getTotalHeatAbsorbing()){
            result = 0;
        }
        return result;

    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing();

    }
    @Override
    public String toString() {

        return "CryoReactor - "+ super.getId()+"\n" +
                "Energy Output: "+ this.getTotalEnergyOutput() + "\n" +
                "Heat Absorbing: " + this.getTotalHeatAbsorbing()+"\n" +
                "Modules: "+ super.getModuleCount()+"\n";


    }
}
