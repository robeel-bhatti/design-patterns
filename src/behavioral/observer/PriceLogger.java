package behavioral.observer;

import java.util.HashMap;
import java.util.Map;

public class PriceLogger implements Observer {

    private final Map<String, Integer> updateCounts = new HashMap<>();

    @Override
    public void onUpdate(String stockSymbol, double price) {
        int count = updateCounts.getOrDefault(stockSymbol, 0) + 1;
        updateCounts.put(stockSymbol, count);
        System.out.printf("[Log #%d] %s: $%.2f%n", count, stockSymbol, price);
    }
}
