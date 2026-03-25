package strategy;

public class Main {

    public static void main(String[] args) {

        // --- Credit card: 3% fee, card number masked ---
        // Expected: Charged $103.00 to credit card ****-****-****-5678 (fee: $3.00)
        PaymentProcessor processor = new PaymentProcessor(new CreditCardPayment());
        System.out.println(processor.pay(100.00, "1234-5678-9012-5678"));

        // --- PayPal: 4% fee, email shown in full ---
        // Expected: Sent $52.00 via PayPal to bob@email.com (fee: $2.00)
        processor = new PaymentProcessor(new PayPalPayment());
        System.out.println(processor.pay(50.00, "bob@email.com"));

        // --- Crypto: flat $1.50 fee, wallet masked (first 6 + last 4) ---
        // Expected: Transferred $201.50 in crypto to wallet 0xABCD...7890 (fee: $1.50)
        processor = new PaymentProcessor(new CryptoPayment());
        System.out.println(processor.pay(200.00, "0xABCDEF1234567890"));

        // --- Bank transfer: $5 fee under $1000, free at $1000+ ---
        // Expected: Wired $505.00 to bank account ****3456 (fee: $5.00)
        processor = new PaymentProcessor(new BankTransferPayment());
        System.out.println(processor.pay(500.00, "9876543456"));

        // Expected: Wired $1500.00 to bank account ****2100 (fee: $0.00)
        System.out.println(processor.pay(1500.00, "1234562100"));

        System.out.println();

        // --- Swap strategy at runtime ---
        // Same processor, different strategy. This is the power of Strategy.
        // Expected:
        // Charged $51.50 to credit card ****-****-****-1111 (fee: $1.50)
        // Sent $52.00 via PayPal to swap@test.com (fee: $2.00)
        processor.setStrategy(new CreditCardPayment());
        System.out.println(processor.pay(50.00, "0000-0000-0000-1111"));

        processor.setStrategy(new PayPalPayment());
        System.out.println(processor.pay(50.00, "swap@test.com"));

        System.out.println();

        // --- Fee calculation independently ---
        // Each strategy should expose its fee logic so it can be queried without paying.
        // Expected:
        // Credit card fee on $100.00: $3.00
        // PayPal fee on $100.00: $4.00
        // Crypto fee on $100.00: $1.50
        // Bank fee on $500.00: $5.00
        // Bank fee on $1500.00: $0.00
        PaymentStrategy cc   = new CreditCardPayment();
        PaymentStrategy pp   = new PayPalPayment();
        PaymentStrategy cry  = new CryptoPayment();
        PaymentStrategy bank = new BankTransferPayment();

        System.out.println(String.format("Credit card fee on $100.00: $%.2f", cc.calculateFee(100.00)));
        System.out.println(String.format("PayPal fee on $100.00: $%.2f", pp.calculateFee(100.00)));
        System.out.println(String.format("Crypto fee on $100.00: $%.2f", cry.calculateFee(100.00)));
        System.out.println(String.format("Bank fee on $500.00: $%.2f", bank.calculateFee(500.00)));
        System.out.println(String.format("Bank fee on $1500.00: $%.2f", bank.calculateFee(1500.00)));
    }
}
