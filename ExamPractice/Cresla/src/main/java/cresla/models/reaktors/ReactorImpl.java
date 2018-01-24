package cresla.models.reaktors;

import cresla.interfaces.Container;
import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.util.LinkedList;

public abstract class ReactorImpl implements Reactor, Identifiable {

    private int id;
    private Container container;

    protected ReactorImpl(int id, Container container) {
        this.id = id;

        this.container = container;
    }

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public abstract long getTotalHeatAbsorbing();


    @SuppressWarnings("unchecked")
    public int getModuleCount(){
        try {
            Class moduleContainerClass = ModuleContainer.class;
            Field field = moduleContainerClass.getDeclaredFields()[1];
            field.setAccessible(true);
            return ((LinkedList<Module>)field.get(this.container)).size();
        } catch (IllegalAccessException e) {
            return 0;
        }
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
            this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
            this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

     Container getContainer() {
        return this.container;
    }


}
