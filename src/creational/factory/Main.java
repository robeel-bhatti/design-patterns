package creational.factory;

import java.util.Scanner;

public class Main {

    /**
     * Client just knows which creator to pick,
     * but is not aware of which object is needed,
     * nor is it aware of the sending logic implementation.
     *
     * Otherwise without creational.factory the client needs to
     * know the concrete object and the exact method
     * on that concrete object to call in order
     * to send a notification. Now it does not
     * need to know either of those things, and the same
     * functionality is still achieved.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String recipient = "Robeel";
        String message = "Hello World";

        System.out.println("Enter notification type: ");
        String type = sc.nextLine();

        NotificationCreator notificationCreator;

        if ("email".equalsIgnoreCase(type)) {
            notificationCreator = new EmailCreator();
        } else if ("slack".equalsIgnoreCase(type)) {
            notificationCreator = new SlackFactory();
        } else {
            notificationCreator = new SmsFactory();
        }

        notificationCreator.transportNotification(recipient, message);
    }
}
