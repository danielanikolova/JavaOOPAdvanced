package MilitaryElite.entities;


import MilitaryElite.interfaces.IMission;

public class Mission implements IMission {

    private String name;
    private String state;

    public Mission(String name, String state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void completeMission() {
        this.state = "Finished";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s\n",
                this.getName(), this.getState() );
    }
}
