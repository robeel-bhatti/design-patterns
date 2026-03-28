package behavioral.observer;

/**
 * OBSERVER PATTERN — Practice Problem: Stock Market Alerts
 *
 * SCENARIO:
 * A StockExchange tracks stock prices. Various observers subscribe to specific
 * stocks and get notified when the price changes. Different observers react
 * differently to the same price update:
 *
 *   - PriceDisplay: simply shows the new price
 *   - ThresholdAlert: only reacts when the price crosses above a given threshold
 *   - PriceLogger: logs every price change with a running count of how many
 *     updates it has seen for that stock
 *
 * The exchange must support:
 *   - Subscribing to a specific stock ticker (not all stocks)
 *   - Unsubscribing
 *   - Multiple observers on the same stock
 *   - An observer subscribing to multiple stocks
 *   - Price updates only notify observers of THAT stock, not others
 */
public class Main {

    public static void main(String[] args) {

        StockExchange exchange = new StockExchange();

        PriceDisplay appleDisplay = new PriceDisplay();
        exchange.subscribe("AAPL", appleDisplay);

        exchange.updatePrice("AAPL", 150.00);
        exchange.updatePrice("AAPL", 155.50);

        System.out.println();

        // --- Observers only get notified for their subscribed stock ---
        // The AAPL display should NOT react to GOOG updates.
        // Expected:
        // [Display] GOOG: $2800.00
        PriceDisplay googleDisplay = new PriceDisplay();
        exchange.subscribe("GOOG", googleDisplay);

        exchange.updatePrice("GOOG", 2800.00);

        System.out.println();


        ThresholdAlert teslaAlert = new ThresholdAlert(900.00);
        exchange.subscribe("TSLA", teslaAlert);

        exchange.updatePrice("TSLA", 850.00);   // below threshold — silence
        exchange.updatePrice("TSLA", 920.00);   // above threshold — fires
        exchange.updatePrice("TSLA", 950.00);   // still above but already crossed — silence

        System.out.println();

        // --- Threshold resets: fires again if price dips below then crosses back ---
        // Expected:
        // [Alert] TSLA crossed above $900.00! Current: $910.00
        exchange.updatePrice("TSLA", 880.00);   // dips below — resets
        exchange.updatePrice("TSLA", 910.00);   // crosses again — fires

        System.out.println();


        PriceLogger amazonLogger = new PriceLogger();
        exchange.subscribe("AMZN", amazonLogger);

        exchange.updatePrice("AMZN", 3400.00);
        exchange.updatePrice("AMZN", 3420.00);
        exchange.updatePrice("AMZN", 3450.00);

        System.out.println();

        // --- Multiple observers on the same stock ---
        // Both display and logger get the MSFT update.
        // Expected:
        // [Display] MSFT: $310.00
        // [Log #1] MSFT: $310.00
        PriceDisplay msftDisplay = new PriceDisplay();
        PriceLogger msftLogger = new PriceLogger();
        exchange.subscribe("MSFT", msftDisplay);
        exchange.subscribe("MSFT", msftLogger);

        exchange.updatePrice("MSFT", 310.00);

        System.out.println();

        // --- One observer subscribed to multiple stocks ---
        // The same logger tracks both NVDA and META independently.
        // Expected:
        // [Log #1] NVDA: $800.00
        // [Log #1] META: $500.00
        // [Log #2] NVDA: $820.00
        PriceLogger multiLogger = new PriceLogger();
        exchange.subscribe("NVDA", multiLogger);
        exchange.subscribe("META", multiLogger);

        exchange.updatePrice("NVDA", 800.00);
        exchange.updatePrice("META", 500.00);
        exchange.updatePrice("NVDA", 820.00);

        System.out.println();

        // --- Unsubscribe stops notifications ---
        // Expected:
        // [Display] AAPL: $160.00
        // (no second display line — googleDisplay was never subscribed to AAPL,
        //  and after unsubscribing appleDisplay, the next update is silent)
        exchange.updatePrice("AAPL", 160.00);
        exchange.unsubscribe("AAPL", appleDisplay);
        exchange.updatePrice("AAPL", 165.00);   // silence — appleDisplay unsubscribed

        System.out.println();

        // --- Updating a stock with no subscribers does nothing (no crash) ---
        // Expected: (nothing printed, no exception)
        exchange.updatePrice("NFLX", 600.00);

        // --- Unsubscribing a non-existent observer does nothing (no crash) ---
        // Expected: (no exception)
        exchange.unsubscribe("NFLX", new PriceDisplay());

        System.out.println("All tests passed.");
    }
}
