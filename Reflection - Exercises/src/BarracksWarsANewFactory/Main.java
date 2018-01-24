package BarracksWarsANewFactory;

import BarracksWarsANewFactory.core.Engine;
import BarracksWarsANewFactory.core.factories.UnitFactoryImpl;
import BarracksWarsANewFactory.data.UnitRepository;
import BarracksWarsANewFactory.interfaces.CommandInterpreter;
import BarracksWarsANewFactory.interfaces.Repository;
import BarracksWarsANewFactory.interfaces.UnitFactory;
import BarracksWarsANewFactory.interpreters.CommandInterpreterImpl;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter interpreter = new CommandInterpreterImpl();
        Runnable engine = new Engine(repository, unitFactory, interpreter);
        engine.run();
    }
}
