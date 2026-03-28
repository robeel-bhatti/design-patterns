package behavioral.strategy;

public class PaymentProcessor {

    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public String pay(double amount, String account) {
        return strategy.pay(amount, account);
    }
}