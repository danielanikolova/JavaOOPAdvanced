package app.commands;

import app.annotations.InjectType;
import app.core.ManagementSystem;

public class ProcessEmergenciesCommand extends BaseCommand{

    @InjectType
    private String type;

    public ProcessEmergenciesCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().processEmergencies(this.type);
    }
}
