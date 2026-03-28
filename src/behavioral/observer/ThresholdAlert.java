package behavioral.observer;

import java.util.HashMap;
import java.util.Map;

public class ThresholdAlert implements Observer {

    private final double threshold;
    private final Map<String, Double> previousPrices = new HashMap<>();

    public ThresholdAlert(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public void onUpdate(String stockSymbol, double price) {
        double previousPrice = previousPrices.getOrDefault(stockSymbol, 0.0);
        if (price > threshold && previousPrice <= threshold) {
            System.out.printf("[Alert] %s crossed above $%.2f! Current: $%.2f%n",
                    stockSymbol, threshold, price);
        }
        previousPrices.put(stockSymbol, price);
    }
}
