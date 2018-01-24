package p02_services;

public class CompositeNotificationService implements NotificationService{

    NotificationService[] notificationServices;
    private Boolean isActive;

    public CompositeNotificationService(Boolean isActive,NotificationService... notificationServices) {
        this.notificationServices = notificationServices;
        this.isActive = isActive;
    }

    @Override
    public void sendNotification() {


    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }
}
