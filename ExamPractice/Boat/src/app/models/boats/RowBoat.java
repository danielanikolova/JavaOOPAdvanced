package app.models.boats;

import app.contracts.BoatRace;
import app.exeptions.IncorrectModelLengthException;
import app.exeptions.IncorrectPropertyValueException;
import app.utility.Validator;

public class RowBoat extends BaseBoat{

    private int oars;

    public RowBoat(String model, int weight, int oars) throws IncorrectPropertyValueException, IncorrectModelLengthException {
        super(model, weight);
        this.setOars(oars);
    }

    @Override
    public double calculateRaceSpeed(BoatRace boatRace) {
        return this.oars * 100D - super.getWeight() + boatRace.getOceanCurrentSpeed();
    }

    private void setOars(int oars) throws IncorrectPropertyValueException {
        Validator.validatePropertyPositiveValue(oars, "Oars");
        this.oars = oars;
    }

}
