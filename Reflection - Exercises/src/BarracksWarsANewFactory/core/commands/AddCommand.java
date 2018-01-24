package BarracksWarsANewFactory.core.commands;

import BarracksWarsANewFactory.interfaces.Unit;


public class AddCommand extends Command{


    @Override
    public String execute() {

        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
