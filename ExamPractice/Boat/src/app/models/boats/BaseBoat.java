package app.models.boats;

import app.contracts.BoatRace;
import app.contracts.Modelable;
import app.exeptions.IncorrectModelLengthException;
import app.exeptions.IncorrectPropertyValueException;
import app.utility.Constants;
import app.utility.Validator;

public abstract class BaseBoat implements Modelable {

    private String model;
    private int weight;

    public BaseBoat(String model, int weight) throws IncorrectModelLengthException, IncorrectPropertyValueException {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) throws IncorrectModelLengthException {
        Validator.validateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    public final int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) throws IncorrectPropertyValueException {
        Validator.validatePropertyPositiveValue(weight, "Weight");
        this.weight = weight;
    }

    public boolean hasEngine() {
        return false;
    }

    public abstract double calculateRaceSpeed(BoatRace boatRace);
}
