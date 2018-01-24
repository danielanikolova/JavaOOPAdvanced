package app.contracts;

import app.exeptions.*;

public interface CommandHandler {

    String executeCommand(String[] parameters)
            throws DuplicateModelException,
            NonExistantModelException,
            RaceAlreadyExistsException,
            NoSetRaceException,
            InsufficientContestantsException, IncorrectPropertyValueException, IncorrectModelLengthException;
}
