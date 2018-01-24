package app.models.boats;

import app.contracts.BoatRace;
import app.exeptions.IncorrectModelLengthException;
import app.exeptions.IncorrectPropertyValueException;

public class SailBoat extends BaseBoat{

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) throws IncorrectPropertyValueException, IncorrectModelLengthException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    @Override
    public double calculateRaceSpeed(BoatRace boatRace) {
        return boatRace.getWindSpeed() * this.sailEfficiency / 100D - super.getWeight() + boatRace.getOceanCurrentSpeed() / 2D;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException("Sail Effectiveness must be between [1...100].");
        }
        this.sailEfficiency = sailEfficiency;
    }
}
