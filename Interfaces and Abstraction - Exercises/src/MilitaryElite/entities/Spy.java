package MilitaryElite.entities;

import MilitaryElite.interfaces.ISoldier;

public class Spy extends Soldier implements ISoldier{

    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
         sb.append(super.toString()).append("\n");
         sb.append(String.format("Code Number: %s\n", this.getCodeNumber()));

            return sb.toString();
    }
}
