package MilitaryElite.entities;

import MilitaryElite.interfaces.ILeutenantGeneral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private List<Private>privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    public List<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivate(Private p) {
        this.privates.add(p);
    }

    @Override
    public List<Private> getPrivateSet() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( super.toString()).append("Privates:\n");
        List<Private>sorted = this.privates.stream().sorted((a, b)-> Integer.compare(b.getId(), a.getId()))
                .collect(Collectors.toList());

        for (Private p:sorted) {
            sb.append("  ").append(p.toString());
        }
        return sb.toString();
    }
}
