package bridge.implementation;

public class SlackChannel implements Channel{

    @Override
    public String deliver(String recipient, String message) {
        return "Slack to " + recipient + ": " + message;
    }
}
