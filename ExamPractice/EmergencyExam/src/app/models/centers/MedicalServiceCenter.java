package app.models.centers;

import app.models.emergencies.Emergency;

import java.util.List;

public class MedicalServiceCenter extends BaseEmergencyCenter{


    public MedicalServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
    }

}
