package factory;

public class SlackFactory extends NotificationCreator {

    @Override
    Notification createNotification() {
        return new SlackNotification();
    }
}
