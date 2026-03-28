package behavioral.chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        SupportHandler tier1 = new BasicSupport();
        SupportHandler tier2 = new TechnicalSupport();
        SupportHandler tier3 = new ManagerSupport();

        tier1.setNext(tier2);
        tier2.setNext(tier3);

        System.out.println("=== Customer Support Ticket System ===\n");

        Ticket passwordReset = new Ticket("Password reset request", Priority.LOW);
        Ticket bugReport = new Ticket("App crashes on login", Priority.MEDIUM);
        Ticket dataLoss = new Ticket("Customer lost all account data", Priority.HIGH);
        Ticket generalQuestion = new Ticket("How do I change my email?", Priority.LOW);

        System.out.println("Ticket: " + passwordReset);
        tier1.handle(passwordReset);

        System.out.println("\nTicket: " + bugReport);
        tier1.handle(bugReport);

        System.out.println("\nTicket: " + dataLoss);
        tier1.handle(dataLoss);

        System.out.println("\nTicket: " + generalQuestion);
        tier1.handle(generalQuestion);
    }
}
