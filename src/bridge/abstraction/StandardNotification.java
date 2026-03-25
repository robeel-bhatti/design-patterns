package bridge.abstraction;

import bridge.implementation.Channel;

public class StandardNotification extends Notification {

    public StandardNotification(Channel channel) {
        super(channel);
    }

    @Override
    public String send(String recipient, String message) {
        return channel.deliver(recipient, message);
    }
}
