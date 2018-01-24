package app.models.boat_engines;

import app.exeptions.IncorrectModelLengthException;
import app.exeptions.IncorrectPropertyValueException;

public class SterndriveEngine extends BaseBoatEngine{

    private static final int STERNDRIVE_MULTIPLIER = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) throws IncorrectPropertyValueException, IncorrectModelLengthException {
        super(model, horsepower, displacement);
    }

    @Override
    protected int getMultiplier() {
        return STERNDRIVE_MULTIPLIER;
    }
}
