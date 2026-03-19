package adapter;

public class PaymentProcessorImpl implements PaymentProcessor {

    @Override
    public boolean charge(String customerId, double amount, String currency) {
        return true;
    }

    @Override
    public boolean refund(String transactionId, double amount) {
        return true;
    }

    @Override
    public TransactionStatus getStatus(String transactionId) {
        return TransactionStatus.PENDING;
    }
}
