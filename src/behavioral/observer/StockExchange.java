package behavioral.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockExchange {

    private final Map<String, List<Observer>> observers = new HashMap<>();

    public void subscribe(String stockSymbol, Observer observer) {
        observers.computeIfAbsent(stockSymbol, k -> new ArrayList<>()).add(observer);
    }

    public void unsubscribe(String stockSymbol, Observer observer) {
        List<Observer> subscribers = observers.get(stockSymbol);
        if (subscribers != null) {
            subscribers.remove(observer);
        }
    }

    public void updatePrice(String stockSymbol, double newPrice) {
        List<Observer> subscribers = observers.get(stockSymbol);
        if (subscribers != null) {
            subscribers.forEach(subscriber -> subscriber.onUpdate(stockSymbol, newPrice));
        }
    }
}
