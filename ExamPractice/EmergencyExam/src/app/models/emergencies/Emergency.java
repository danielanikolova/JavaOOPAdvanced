package app.models.emergencies;

import app.enums.EmergencyLevel;
import app.utils.RegistrationTime;

public interface Emergency {
    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();

    Integer getResultAfterProcessing();

}
