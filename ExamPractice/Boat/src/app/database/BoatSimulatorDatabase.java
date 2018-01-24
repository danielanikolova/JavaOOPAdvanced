package app.database;

import app.contracts.Repository;
import app.models.boat_engines.BaseBoatEngine;
import app.models.boats.BaseBoat;

public class BoatSimulatorDatabase {

    Repository<BaseBoat> boats;
    Repository<BaseBoatEngine> engines;

    public BoatSimulatorDatabase() {
        this.boats = new DefaultRepository<>();
        this.engines = new DefaultRepository<>();
    }

    public Repository<BaseBoat> getBoats() {
        return this.boats;
    }

    public Repository<BaseBoatEngine> getEngines() {
        return this.engines;
    }
}
