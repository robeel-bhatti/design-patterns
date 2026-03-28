package behavioral.chainOfResponsibility;

/**
 * Abstract class to hold shared state and behavior for child classes
 * Abstract because it's not supposed to be instantiated.
 * For consistency all methods to be implemented still live in the interface
 */
public abstract class SupportHandler {

    protected SupportHandler nextHandler;

    protected Priority priority;

    public SupportHandler(Priority priority) {
        this.priority = priority;
    }

    protected void setNext(SupportHandler handler) {
        this.nextHandler = handler;
    }

    protected void handle(Ticket ticket) {
        if (this.priority.equals(ticket.getPriority())) {
            String msg = String.format(
                    "%s: Resolved \"%s\"",
                    this.getClass().getSimpleName(),
                    ticket.getDescription()
            );
            System.out.println(msg);
        } else if (this.nextHandler != null) {
            this.nextHandler.handle(ticket);
        } else {
            System.out.println("Ticket could not be resolved");
        }
    }
}
