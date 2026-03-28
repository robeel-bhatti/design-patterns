package structural.adapter;

public class PaymentProcessorAdapter implements PaymentProcessor {

    private final StripeSDK stripeSDK;

    public PaymentProcessorAdapter(StripeSDK stripeSDK) {
        this.stripeSDK = stripeSDK;
    }

    @Override
    public boolean charge(String customerId, double amount, String currency) {
        this.stripeSDK.createCharge(customerId, (long) amount, currency);
        return true;
    }

    @Override
    public boolean refund(String transactionId, double amount) {
        this.stripeSDK.createReversal(transactionId, (long) amount);
        return true;
    }

    @Override
    public TransactionStatus getStatus(String transactionId) {
        StripeCharge stripeCharge = this.stripeSDK.retrieveCharge(transactionId);
        return stripeCharge.getStatus();
    }
}
