package factory;

public class EmailCreator extends NotificationCreator {

    @Override
    Notification createNotification() {
        return new EmailNotification();
    }
}
