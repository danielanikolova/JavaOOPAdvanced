package app.models.boat_engines;

import app.contracts.Modelable;
import app.exeptions.IncorrectModelLengthException;
import app.exeptions.IncorrectPropertyValueException;
import app.utility.Constants;
import app.utility.Validator;

public abstract class BaseBoatEngine implements Modelable {
    private String model;
    private int horsepower;
    private int displacement;
    public int output;

    public BaseBoatEngine(String model, int horsepower, int displacement) throws IncorrectModelLengthException, IncorrectPropertyValueException {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public int getOutput() {
        return this.horsepower * this.getMultiplier() + this.displacement;
    }

    protected abstract int getMultiplier();

    private void setModel(String model) throws IncorrectModelLengthException {
        Validator.validateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }

    private void setHorsepower(int horsepower) throws IncorrectPropertyValueException {
        Validator.validatePropertyPositiveValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) throws IncorrectPropertyValueException {
        Validator.validatePropertyPositiveValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
