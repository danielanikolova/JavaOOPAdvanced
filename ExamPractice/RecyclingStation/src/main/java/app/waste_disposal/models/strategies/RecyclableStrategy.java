package app.waste_disposal.models.strategies;

import app.waste_disposal.BaseProcessingData;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

public class RecyclableStrategy extends BaseDisposeStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {

        double totalVolume = garbage.getVolumePerKg()*garbage.getWeight();
        double energyBalance = 0 - 0.50*totalVolume;
        double capitalBalance = garbage.getWeight()*400;


        return new BaseProcessingData(energyBalance, capitalBalance);
    }
}
