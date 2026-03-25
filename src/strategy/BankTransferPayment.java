package strategy;

public class BankTransferPayment implements PaymentStrategy {

    @Override
    public String pay(double amount, String account) {
        double fee = calculateFee(amount);
        double total = amount + fee;
        return String.format("Wired $%.2f to bank account %s (fee: $%.2f)",
                total, maskBank(account), fee);
    }

    @Override
    public Double calculateFee(double amount) {
        return (amount > 1000) ? 0.00 : 5.00;
    }

    private String maskBank(String bank) {
        return "****" + bank.substring(bank.length() - 4);
    }
}
