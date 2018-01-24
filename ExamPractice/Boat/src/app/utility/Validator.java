package app.utility;

import app.exeptions.IncorrectModelLengthException;
import app.exeptions.IncorrectPropertyValueException;

public final class Validator
{
    private Validator() {
    }

    public static void validatePropertyPositiveValue(int value, String propertyName) throws IncorrectPropertyValueException {
        if (value <= 0) {
            throw new IncorrectPropertyValueException(String.format(Constants.IncorrectPropertyValueMessage, propertyName));
        }
    }

    public static void validateModelLength(String value, int minModelLength) throws IncorrectModelLengthException {
        if (value.length() < minModelLength) {
            throw new IncorrectModelLengthException(String.format(Constants.IncorrectModelLengthMessage, minModelLength));
        }
    }



}
