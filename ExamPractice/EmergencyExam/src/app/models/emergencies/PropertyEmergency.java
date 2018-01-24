package app.models.emergencies;

import app.enums.EmergencyLevel;
import app.utils.RegistrationTime;

public class PropertyEmergency extends BaseEmergency {
    private Integer damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage) {
        super(description, emergencyLevel, registrationTime);
        this.damage = damage;
    }

    @Override
    public Integer getResultAfterProcessing() {
        return this.damage;
    }
}
