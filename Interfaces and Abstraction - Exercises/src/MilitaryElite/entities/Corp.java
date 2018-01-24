package MilitaryElite.entities;

import MilitaryElite.interfaces.ICorp;

public class Corp implements ICorp {

    private String corps;

    public Corp(String corps) {
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        return this.corps;
    }
}
