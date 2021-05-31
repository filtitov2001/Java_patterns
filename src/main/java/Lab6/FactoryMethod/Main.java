package Lab6.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        Notification notification1 = notificationFactory.createNotification("EMAIL");
        notification.notifyUser();
        notification1.notifyUser();
    }
}
