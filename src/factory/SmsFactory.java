package factory;

public class SmsFactory extends NotificationCreator {

    @Override
    Notification createNotification() {
        return new SmsNotification();
    }
}
