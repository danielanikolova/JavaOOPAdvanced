package MilitaryElite.entities;

import MilitaryElite.interfaces.IComando;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier implements IComando{

    private List<Mission>missions;


    public Commando(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.missions = new ArrayList<>();
    }

    @Override
    public List<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(Mission mission) {
        this.getMissions().add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Corps: %s\nMissions:\n", super.getCorps().toString()));

        this.getMissions().stream().filter(m->m.getState()
                .equalsIgnoreCase("inProgress")).forEach(r->sb.append(r.toString()));

        return sb.toString();
    }
}
