package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Observer Interface
interface StockObserver {
  void update(String stockSymbol, double oldPrice, double newPrice);
}

// Subject (publisher)
class StockMarket {
  private final Map<String, Double> stockPrices = new HashMap<>();
  private final List<StockObserver> observers = new ArrayList<>();

  public void addObserver(StockObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(StockObserver observer) {
    observers.remove(observer);
  }

  public void addStock(String symbol, double initialPrice) {
    stockPrices.put(symbol, initialPrice);
  }

  public void updatePrice(String symbol, double newPrice) {
    if (!stockPrices.containsKey(symbol)) {
      throw new IllegalArgumentException("Unknown stock symbol: " + symbol);
    }

    double oldPrice = stockPrices.get(symbol);
    if (oldPrice != newPrice) {
      stockPrices.put(symbol, newPrice);
      notifyObservers(symbol, oldPrice, newPrice);
    }
  }

  private void notifyObservers(String symbol, double oldPrice, double newPrice) {
    for (StockObserver observer : observers) {
      observer.update(symbol, oldPrice, newPrice);
    }
  }
}

// Concrete Observers
class PortfolioManager implements StockObserver {
  @Override
  public void update(String stockSymbol, double oldPrice, double newPrice) {
    double change = ((newPrice - oldPrice) / oldPrice) * 100;
    if (Math.abs(change) >= 5) {
      System.out.printf("[PORTFOLIO] Significant change in %s: %.2f -> %.2f (%.2f%%)%n",
          stockSymbol, oldPrice, newPrice, change);
    }
  }
}

class StockLogger implements StockObserver {
  @Override
  public void update(String stockSymbol, double oldPrice, double newPrice) {
    System.out.printf("[LOGGER] %s updated: %.2f -> $%.2f%n",
        stockSymbol, oldPrice, newPrice);
  }
}

public class StockMarketDemo {
  public static void main(String[] args) {
    var market = new StockMarket();

    // Observers
    var portfolio = new PortfolioManager();
    var logger = new StockLogger();

    // Register observers
    market.addObserver(portfolio);
    market.addObserver(logger);

    // Add stocks
    market.addStock("AAPL", 150.00);
    market.addStock("GOOGL", 2500.00);

    // Simulate price changes
    market.updatePrice("AAPL", 155.00); // +3.33% (logger only)
    market.updatePrice("GOOGL", 2625.00); // +5% (both notify)
    market.updatePrice("AAPL", 155.00); // No change (no notification)
  }
}
