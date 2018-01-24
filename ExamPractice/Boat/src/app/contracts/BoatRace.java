package app.contracts;

import app.exeptions.DuplicateModelException;
import app.models.boats.BaseBoat;

import java.util.List;

public interface BoatRace {

    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean allowsMotorboats();

    void addParticipant(BaseBoat boat) throws DuplicateModelException;

    List<BaseBoat> getParticipants();
}
