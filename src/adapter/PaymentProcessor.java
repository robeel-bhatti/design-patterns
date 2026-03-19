package adapter;

public interface PaymentProcessor {

    boolean charge(String customerId, double amount, String currency);

    boolean refund(String transactionId, double amount);

    TransactionStatus getStatus(String transactionId);
}
