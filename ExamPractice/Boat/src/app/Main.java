package app;

import app.contracts.BoatSimulatorController;
import app.contracts.CommandHandler;
import app.controllers.DefaultBoatSimulatorController;
import app.core.DefaultCommandHandler;
import app.core.Engine;
import app.database.BoatSimulatorDatabase;

public class Main {
    public static void main(String[] args) {
        BoatSimulatorDatabase database = new BoatSimulatorDatabase();
        BoatSimulatorController controller = new DefaultBoatSimulatorController(database);
        CommandHandler commandHandler = new DefaultCommandHandler(controller);
        Runnable engine = new Engine(commandHandler);
        engine.run();
    }
}
