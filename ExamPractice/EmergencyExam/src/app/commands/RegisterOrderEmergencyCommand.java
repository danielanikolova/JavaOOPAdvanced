package app.commands;

import app.annotations.InjectArgs;
import app.commands.BaseCommand;
import app.core.ManagementSystem;
import app.enums.EmergencyLevel;
import app.enums.Status;
import app.models.emergencies.Emergency;
import app.models.emergencies.HealthEmergency;
import app.models.emergencies.OrderEmergency;
import app.utils.RegistrationTime;
import app.utils.RegistrationTimeImpl;

public class RegisterOrderEmergencyCommand extends BaseCommand{

    @InjectArgs
    private String[] params;
    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterOrderEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        this.setRegistrationTime(this.params[3]);
        Status status = Status.valueOf(this.params[4].replaceAll("-", "_").toUpperCase());

        this.emergency = new OrderEmergency(description, level, this.registrationTime, status);
        return super.getManagementSystem().registerOrderEmergency(this.emergency);
    }

    private void setRegistrationTime(String time) {
        this.registrationTime = new RegistrationTimeImpl(time);
    }
}
