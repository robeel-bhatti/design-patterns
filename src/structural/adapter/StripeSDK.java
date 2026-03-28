package structural.adapter;

public class StripeSDK {

    public StripeResult createCharge(String stripeCustomerId, long amountInCents, String currencyCode) {
        return new StripeResult(stripeCustomerId, true);
    }

    public boolean createReversal(String stripeChargeId, long amountInCents) {
        return true;
    }

    public StripeCharge retrieveCharge(String stripeChargeId) {
        return new StripeCharge(TransactionStatus.SUCCESS);
    }
}
