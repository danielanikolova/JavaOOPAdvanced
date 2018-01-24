package app.models.emergencies;

import app.enums.EmergencyLevel;
import app.enums.Status;
import app.utils.RegistrationTime;

public class OrderEmergency extends BaseEmergency {

    private Status status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Status status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }

    @Override
    public Integer getResultAfterProcessing() {
        switch (this.status) {
            case SPECIAL:
                return 1;
            case NON_SPECIAL:
                return 0;
            default:
                return null;
        }
    }
}
