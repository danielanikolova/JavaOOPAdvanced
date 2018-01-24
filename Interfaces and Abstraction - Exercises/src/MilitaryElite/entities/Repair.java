package MilitaryElite.entities;

import MilitaryElite.interfaces.IRepair;

public class Repair implements IRepair {

    private String partName;
    private int workedHours;

    public Repair(String partName, int workedHours) {
        this.partName = partName;
        this.workedHours = workedHours;
    }
    @Override
    public String getPartName() {
        return partName;
    }

    @Override
    public int getWorkedHours() {
        return workedHours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d\n"
                ,this.getPartName(), this.getWorkedHours());
    }
}
