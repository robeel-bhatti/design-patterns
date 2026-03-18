package factory;

public class SlackNotification implements Notification {

    @Override
    public void send(String recipient, String message) {
        System.out.println("This is a a slack notification to " + recipient + " with message " +  message);
    }
}
