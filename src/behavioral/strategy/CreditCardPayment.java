package behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public String pay(double amount, String account) {
        double fee = calculateFee(amount);
        double total = amount + fee;
        return String.format("Charged $%.2f to credit card %s (fee: $%.2f)",
                total, maskCard(account), fee);
    }

    @Override
    public Double calculateFee(double amount) {
        return amount * 0.03;
    }

    private String maskCard(String card) {
        return "****-****-****-" + card.substring(card.length() - 4);
    }
}
