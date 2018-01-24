package app.waste_disposal.models.strategies;

import app.waste_disposal.BaseProcessingData;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

public class StorableStrategy extends BaseDisposeStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalVolume = garbage.getVolumePerKg()*garbage.getWeight();
        double energyBalance = 0 - 0.13*totalVolume;
        double capitalBalance = 0- totalVolume*0.65;


        return new BaseProcessingData(energyBalance, capitalBalance);
    }
}
