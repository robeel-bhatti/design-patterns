package strategy;

public class CryptoPayment implements PaymentStrategy {

    @Override
    public String pay(double amount, String account) {
        double fee = calculateFee(amount);
        double total = amount + fee;
        return String.format("Transferred $%.2f in crypto to wallet %s (fee: $%.2f)",
                total, maskWallet(account), fee);
    }

    @Override
    public Double calculateFee(double amount) {
        return 1.50;
    }

    private String maskWallet(String wallet) {
        return wallet.substring(0, 6) + "..." + wallet.substring(wallet.length() - 4);
    }
}
