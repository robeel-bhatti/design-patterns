package bridge.implementation;

public class SmsChannel implements Channel {

    @Override
    public String deliver(String recipient, String message) {
        return "SMS to " + recipient + ": " + message;
    }
}
