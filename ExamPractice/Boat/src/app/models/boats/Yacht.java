package app.models.boats;

import app.contracts.BoatRace;
import app.exeptions.IncorrectModelLengthException;
import app.exeptions.IncorrectPropertyValueException;
import app.models.boat_engines.BaseBoatEngine;
import app.utility.Validator;

public class Yacht extends BaseMotorBoat{

    private int cargo;

    public Yacht(String model, int weight, BaseBoatEngine engine, int cargo) throws IncorrectPropertyValueException, IncorrectModelLengthException {
        super(model, weight, engine);
        this.setCargo(cargo);
    }

    @Override
    public double calculateRaceSpeed(BoatRace boatRace) {
        return super.getEngine().getOutput() - super.getWeight() - this.cargo + boatRace.getOceanCurrentSpeed() / 2D;
    }

    private void setCargo(int cargo) throws IncorrectPropertyValueException {
        Validator.validatePropertyPositiveValue(cargo, "Cargo Weight");
        this.cargo = cargo;
    }
}
