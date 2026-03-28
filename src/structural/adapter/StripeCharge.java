package structural.adapter;

public class StripeCharge {

    private final TransactionStatus status;

    public StripeCharge(TransactionStatus status) {
        this.status = status;
    }

    public TransactionStatus getStatus() {
        return status;
    }
}
