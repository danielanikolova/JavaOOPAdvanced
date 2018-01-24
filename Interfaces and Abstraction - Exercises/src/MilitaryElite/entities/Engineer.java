package MilitaryElite.entities;

import MilitaryElite.interfaces.IEngineer;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {

    List<Repair>repairs;

    public Engineer(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.repairs = new ArrayList<>();
    }

    @Override
    public List<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepair(Repair repair) {
        this.getRepairs().add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Corps: %s\nRepairs:\n", super.getCorps().toString()));

        this.getRepairs().forEach(r->sb.append(r.toString()));

        return sb.toString();
    }
}
