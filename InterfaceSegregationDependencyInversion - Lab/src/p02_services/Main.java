package p02_services;


public class Main {
    public static void main(String[] args) {

        CompositeNotificationService service =
                new CompositeNotificationService(true, new EmailNotificationService(true));

        OnlineStoreOrder  order = new OnlineStoreOrder(service);
    }
}
