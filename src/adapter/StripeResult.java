package adapter;

public class StripeResult {

    private final String chargeId;

    private final boolean succeeded;

    public StripeResult(String chargeId, boolean succeeded) {
        this.chargeId = chargeId;
        this.succeeded = succeeded;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public String getChargeId() {
        return chargeId;
    }
}
