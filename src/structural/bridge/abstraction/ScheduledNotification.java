package structural.bridge.abstraction;

import structural.bridge.implementation.Channel;

public class ScheduledNotification extends Notification {

    private final String time;

    public ScheduledNotification(Channel channel, String time) {
        super(channel);
        this.time = time;
    }

    @Override
    public String send(String recipient, String message) {
        String scheduledMessage = "[Scheduled: " + time + "] " + message;
        return channel.deliver(recipient, scheduledMessage);
    }
}
