package bridge.implementation;

public class EmailChannel implements Channel {

    @Override
    public String deliver(String recipient, String message) {
        return "Email to " + recipient + ": " + message;
    }
}
