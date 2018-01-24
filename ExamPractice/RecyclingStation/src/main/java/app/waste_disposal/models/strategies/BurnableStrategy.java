package app.waste_disposal.models.strategies;

import app.waste_disposal.BaseProcessingData;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

public class BurnableStrategy extends BaseDisposeStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {


        double totalVolume = garbage.getVolumePerKg()*garbage.getWeight();
        double energyBalance = totalVolume - 0.20*totalVolume;
        double capitalBalance = 0.0;

        return new BaseProcessingData(energyBalance, capitalBalance);
    }
}
