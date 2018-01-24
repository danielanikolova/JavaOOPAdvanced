package app.models.centers;

public interface EmergencyCenter {
    String getName();

    Integer getAmountOfMaximumEmergencies();

    Boolean isForRetirement();

    Integer getProcessedEmergencies();

    void processEmergency();
}
