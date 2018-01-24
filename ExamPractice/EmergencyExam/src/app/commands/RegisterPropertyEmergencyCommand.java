package app.commands;

import app.annotations.InjectArgs;
import app.commands.BaseCommand;
import app.core.ManagementSystem;
import app.enums.EmergencyLevel;
import app.models.emergencies.Emergency;
import app.models.emergencies.PropertyEmergency;
import app.utils.RegistrationTime;
import app.utils.RegistrationTimeImpl;


public class RegisterPropertyEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterPropertyEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        this.setRegistrationTime(this.params[3]);
        Integer damage = Integer.valueOf(this.params[4]);

        this.emergency = new PropertyEmergency(description, level, this.registrationTime, damage);
        return super.getManagementSystem().registerPropertyEmergency(this.emergency);
    }

    private void setRegistrationTime(String time) {
        this.registrationTime = new RegistrationTimeImpl(time);
    }


}
