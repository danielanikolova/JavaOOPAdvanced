package app.models.boats;

import app.exeptions.IncorrectModelLengthException;
import app.exeptions.IncorrectPropertyValueException;
import app.models.boat_engines.BaseBoatEngine;

public abstract class BaseMotorBoat extends BaseBoat {

    private BaseBoatEngine engine;

    public BaseMotorBoat(String model, int weight, BaseBoatEngine engine) throws IncorrectPropertyValueException, IncorrectModelLengthException {
        super(model, weight);
        this.engine = engine;
    }

    @Override
    public boolean hasEngine() {
        return true;
    }

    protected BaseBoatEngine getEngine() {
        return this.engine;
    }
}
