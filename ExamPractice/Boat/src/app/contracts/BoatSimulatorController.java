package app.contracts;

import app.exeptions.*;

public interface BoatSimulatorController {

    String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException, IncorrectPropertyValueException, IncorrectModelLengthException;

    String createRowBoat(String model, int weight, int oars) throws DuplicateModelException, IncorrectPropertyValueException, IncorrectModelLengthException;

    String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException, IncorrectPropertyValueException, IncorrectModelLengthException;

    String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException, IncorrectPropertyValueException, IncorrectModelLengthException;

    String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException, IncorrectPropertyValueException, IncorrectModelLengthException;

    String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException, IncorrectPropertyValueException;

    String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException;

    String startRace() throws InsufficientContestantsException, NoSetRaceException;

    String getStatistics()throws NoSetRaceException;
}
