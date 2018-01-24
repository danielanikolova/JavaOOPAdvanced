package cresla.interfaces;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;

public interface Container {

    long getTotalEnergyOutput();

    long getTotalHeatAbsorbing();

    void addEnergyModule(EnergyModule energyModule);

    void addAbsorbingModule(AbsorbingModule absorbingModule);
}
