package app.commands;

import app.annotations.InjectArgs;
import app.commands.BaseCommand;
import app.core.ManagementSystem;
import app.models.centers.EmergencyCenter;
import app.models.centers.PoliceServiceCenter;

public class RegisterPoliceServiceCenterCommand extends BaseCommand{

    @InjectArgs
    private String[] params;
    private EmergencyCenter emergencyCenter;

    public RegisterPoliceServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String name = this.params[1];
        Integer amountOfEmergencies = Integer.valueOf(this.params[2]);

        this.emergencyCenter = new PoliceServiceCenter(name, amountOfEmergencies);
        return super.getManagementSystem().registerPoliceServiceCenter(this.emergencyCenter);
    }
}
