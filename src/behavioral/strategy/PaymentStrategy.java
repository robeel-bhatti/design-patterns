package behavioral.strategy;

public interface PaymentStrategy {

    String pay(double amount, String account);

    Double calculateFee(double amount);

}
