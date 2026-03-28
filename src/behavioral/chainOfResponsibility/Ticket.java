package behavioral.chainOfResponsibility;

public class Ticket {

    private final String description;

    private final Priority priority;

    public Ticket(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", priority, description);
    }
}
