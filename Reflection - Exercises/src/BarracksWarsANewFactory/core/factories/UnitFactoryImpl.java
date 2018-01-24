package BarracksWarsANewFactory.core.factories;


import BarracksWarsANewFactory.interfaces.Unit;
import BarracksWarsANewFactory.interfaces.UnitFactory;
import BarracksWarsANewFactory.models.units.AbstractUnit;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "BarracksWarsANewFactory.models.units.";

    @Override
    public Unit createUnit(String unitType) {

        Unit unit = null;
        try {

            Class<?> current = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> currentConstructor = current.getDeclaredConstructor();
            unit = (AbstractUnit) currentConstructor.newInstance();
            

        }catch (NotImplementedException ex){
            throw new NotImplementedException();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
