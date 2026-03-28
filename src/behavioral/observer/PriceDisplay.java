package behavioral.observer;

public class PriceDisplay implements Observer {

    @Override
    public void onUpdate(String stockSymbol, double price) {
        System.out.printf("[Display] %s: $%.2f%n", stockSymbol, price);
    }
}
