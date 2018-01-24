package BarracksWarsANewFactory.core.commands;


import BarracksWarsANewFactory.interfaces.Executable;
import BarracksWarsANewFactory.interfaces.Repository;
import BarracksWarsANewFactory.interfaces.UnitFactory;

public abstract class Command implements Executable{

    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Command() {

    }


    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
