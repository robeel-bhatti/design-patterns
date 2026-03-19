package adapter;

public class CheckoutService {

    private final PaymentProcessor processor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.processor = paymentProcessor;
    }

    public boolean processOrder(Order order) {
        boolean charged = processor.charge(order.getCustomerId(), order.getTotal(), order.getCurrency());
        if (!charged) {
            throw new RuntimeException("Charge failed for order: " + order.getCustomerId());
        }
        return true;
    }

    public boolean cancelOrder(String orderId, String transactionId, double amount) {
        return processor.refund(orderId, amount);
    }
}
