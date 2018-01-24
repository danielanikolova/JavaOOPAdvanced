package app.models.boat_engines;

import app.exeptions.IncorrectModelLengthException;
import app.exeptions.IncorrectPropertyValueException;

public class JetEngine extends BaseBoatEngine{

    private static final int JET_MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) throws IncorrectPropertyValueException, IncorrectModelLengthException {
        super(model, horsepower, displacement);
    }

    @Override
    protected int getMultiplier() {
        return JET_MULTIPLIER;
    }
}
