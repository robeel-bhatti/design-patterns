package creational.factory;

public class SmsNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending SMS notification to " + recipient + " with message " + message);
    }
}
