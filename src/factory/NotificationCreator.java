package factory;

public abstract class NotificationCreator {

    abstract Notification createNotification();

    /**
     * Uses dynamic dispatch to determine which subclass createNotification implementation to use.
     */
    public void transportNotification(String recipient, String message) {
        Notification notification = this.createNotification();
        notification.send(recipient, message);
    }
}
