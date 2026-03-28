package structural.bridge;

import structural.bridge.abstraction.Notification;
import structural.bridge.abstraction.ScheduledNotification;
import structural.bridge.abstraction.StandardNotification;
import structural.bridge.abstraction.UrgentNotification;
import structural.bridge.implementation.EmailChannel;
import structural.bridge.implementation.SlackChannel;
import structural.bridge.implementation.Channel;
import structural.bridge.implementation.SmsChannel;

public class Main {

    public static void main(String[] args) {

        // --- Standard notifications across all channels ---
        // Expected:
        // Email to alice@company.com: Your report is ready.
        // SMS to +1-555-0100: Your report is ready.
        // Slack to @alice: Your report is ready.
        Notification n1 = new StandardNotification(new EmailChannel());
        Notification n2 = new StandardNotification(new SmsChannel());
        Notification n3 = new StandardNotification(new SlackChannel());

        System.out.println(n1.send("alice@company.com", "Your report is ready."));
        System.out.println(n2.send("+1-555-0100", "Your report is ready."));
        System.out.println(n3.send("@alice", "Your report is ready."));

        System.out.println();

        // --- Urgent notifications send TWO messages ---
        // The second message is always: "This is urgent! Please respond ASAP."
        // The two messages are joined by a newline.
        // Expected:
        // Email to bob@company.com: Server is down!
        // Email to bob@company.com: This is urgent! Please respond ASAP.
        //
        // SMS to +1-555-0200: Server is down!
        // SMS to +1-555-0200: This is urgent! Please respond ASAP.
        Notification u1 = new UrgentNotification(new EmailChannel());
        Notification u2 = new UrgentNotification(new SmsChannel());

        System.out.println(u1.send("bob@company.com", "Server is down!"));
        System.out.println();
        System.out.println(u2.send("+1-555-0200", "Server is down!"));

        System.out.println();

        // --- Scheduled notifications prepend a timestamp ---
        // Expected:
        // Slack to @team-leads: [Scheduled: 2026-03-25 09:00] Sprint review starts in 1 hour.
        //
        // Email to team@company.com: [Scheduled: 2026-03-25 09:00] Sprint review starts in 1 hour.
        Notification s1 = new ScheduledNotification(new SlackChannel(), "2026-03-25 09:00");
        Notification s2 = new ScheduledNotification(new EmailChannel(), "2026-03-25 09:00");

        System.out.println(s1.send("@team-leads", "Sprint review starts in 1 hour."));
        System.out.println();
        System.out.println(s2.send("team@company.com", "Sprint review starts in 1 hour."));

        System.out.println();

        // --- Swap channels at runtime ---
        // The same abstraction works with any channel — that's the Bridge.
        // Expected:
        // Email to cto@company.com: Deployment failed on prod.
        // Email to cto@company.com: This is urgent! Please respond ASAP.
        //
        // Slack to @cto: Deployment failed on prod.
        // Slack to @cto: This is urgent! Please respond ASAP.
        Notification urgentEmail = new UrgentNotification(new EmailChannel());
        Notification urgentSlack = new UrgentNotification(new SlackChannel());

        System.out.println(urgentEmail.send("cto@company.com", "Deployment failed on prod."));
        System.out.println();
        System.out.println(urgentSlack.send("@cto", "Deployment failed on prod."));

        System.out.println();

        // --- Verify independence: same channel, different abstractions ---
        // All three use SlackChannel but behave differently based on the abstraction.
        // Expected:
        // Slack to @dev: Build completed.
        //
        // Slack to @dev: Build completed.
        // Slack to @dev: This is urgent! Please respond ASAP.
        //
        // Slack to @dev: [Scheduled: 2026-03-26 14:00] Build completed.
        Channel slack = new SlackChannel();

        Notification std = new StandardNotification(slack);
        Notification urg = new UrgentNotification(slack);
        Notification sch = new ScheduledNotification(slack, "2026-03-26 14:00");

        System.out.println(std.send("@dev", "Build completed."));
        System.out.println();
        System.out.println(urg.send("@dev", "Build completed."));
        System.out.println();
        System.out.println(sch.send("@dev", "Build completed."));
    }
}
