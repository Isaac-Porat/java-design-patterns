package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Observer Interface
interface ShoeObserver {
  void update(String shoe, double oldPrice, double newPrice);
}

// Subject (publisher)
class NikeStore {
  private final Map<String, Double> shoePrices = new HashMap<>();
  private final Map<String, ShoeObserver> observers = new HashMap<>();

  public void addObserver(String shoe, ShoeObserver observer) {
    observers.put(shoe, observer);
  }

  public void removeObserver(String shoe, ShoeObserver observer) {
    observers.replace(shoe, observer);
  }

  public void addShoe(String shoe, double price) {
    shoePrices.put(shoe, price);
  }

  public void updateShoe(String shoe, double newPrice) {
    if (!shoePrices.containsKey(shoe)) {
      throw new IllegalArgumentException("Unknown shoe: " + shoe);
    }

    double oldPrice = shoePrices.get(shoe);
    if (oldPrice != newPrice) {
      shoePrices.put(shoe, newPrice);
      notifyObservers(shoe, oldPrice, newPrice);
    }
  }

  private void notifyObservers(String shoe, double oldPrice, double newPrice) {
    ShoeObserver observer = observers.get(shoe);
    if (observer != null) {
      observer.update(shoe, oldPrice, newPrice);
    }
  }
}

// Concrete Observers
class ShoeManager implements ShoeObserver {
  @Override
  public void update(String shoe, double oldPrice, double newPrice) {
    if (newPrice > oldPrice) {
      System.out.printf("Difference in price: %s - $%.1f%n", shoe, newPrice - oldPrice);
    }
  }
}

public class SneakerPrice {
  public static void main(String[] args) {
    var store = new NikeStore();

    var shoeManager = new ShoeManager();

    store.addShoe("Nike", 200);
    store.addShoe("Ben", 200);

    store.addObserver("Nike", shoeManager);
    store.addObserver("Ben", shoeManager);

    store.updateShoe("Nike", 564);
    store.updateShoe("Ben", 689);
  }
}
