package app.models.emergencies;

import app.enums.EmergencyLevel;
import app.utils.RegistrationTime;


public class HealthEmergency extends BaseEmergency{

    private Integer casualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer casualties) {
        super(description, emergencyLevel, registrationTime);
        this.casualties = casualties;
    }

    @Override
    public Integer getResultAfterProcessing() {
        return this.casualties;
    }
}
