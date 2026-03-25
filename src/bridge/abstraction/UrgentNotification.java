package bridge.abstraction;

import bridge.implementation.Channel;

public class UrgentNotification extends Notification {

    private static final String SUFFIX = "This is urgent! Please respond ASAP.";

    public UrgentNotification(Channel channel) {
        super(channel);
    }

    @Override
    public String send(String recipient, String message) {
        String first = channel.deliver(recipient, message);
        String second = channel.deliver(recipient, SUFFIX);
        return first + "\n" + second;
    }
}
