package adapter;

public class Main {

    public static void main(String[] args) {
        // checkout service depends on payment processor implementation
        PaymentProcessor paymentProcessor = new PaymentProcessorImpl();
        CheckoutService checkoutService = new CheckoutService(paymentProcessor);

        Order order = new Order();
        order.setCustomerId("123");
        order.setTotal(500);
        order.setCurrency("USD");

        boolean res = checkoutService.processOrder(order);
        boolean orderRes = checkoutService.cancelOrder("123", "456", 600);
        System.out.println("Results using PaymentProcessorImpl: " + res + " " + orderRes);

        // wrap strike sdk inside the adapter class
        // checkout service doesn't know anything about stripe sdk but is able to use it
        // by using the adapter interface which checkout service is already familiar with
        StripeSDK stripeSDK = new StripeSDK();
        PaymentProcessor paymentProcessor2 = new PaymentProcessorAdapter(stripeSDK);
        CheckoutService checkoutService2 = new CheckoutService(paymentProcessor2);
        boolean res2 = checkoutService2.processOrder(order);
        boolean orderRes2 = checkoutService2.cancelOrder("123", "456", 600);

        System.out.println("Results using PaymentProcessorAdapter: " + res2 + " " + orderRes2);

    }
}
