package app.exeptions;

public class IncorrectPropertyValueException extends RuntimeException {
    public IncorrectPropertyValueException(String message) {
        super(message);
    }
}
