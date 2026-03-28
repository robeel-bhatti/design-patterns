package structural.bridge.abstraction;

import structural.bridge.implementation.Channel;

public abstract class Notification {

    public final Channel channel;

    public Notification(Channel channel) {
        this.channel = channel;
    }

    public abstract String send(String recipient, String message);

}
