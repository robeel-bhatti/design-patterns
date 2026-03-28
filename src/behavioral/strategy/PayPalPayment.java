package behavioral.strategy;

public class PayPalPayment implements PaymentStrategy {

    @Override
    public String pay(double amount, String account) {
        double fee = calculateFee(amount);
        double total = amount + fee;
        return String.format("Sent $%.2f via PayPal to %s (fee: $%.2f)",
                total, account, fee);
    }

    @Override
    public Double calculateFee(double amount) {
        return amount * 0.04;
    }
}
