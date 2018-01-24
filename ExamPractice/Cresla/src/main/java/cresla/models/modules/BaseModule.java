package cresla.models.modules;

import cresla.interfaces.Identifiable;
import cresla.interfaces.Module;

public abstract class BaseModule implements Module, Identifiable{

    private int id;

    protected BaseModule(int id) {
        this.id =id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
