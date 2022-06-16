package Managers;

import Products.Product;
import Listeners.MarketListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketManager {
    Map<String, List<MarketListener>> listeners = new HashMap<>();

    public MarketManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, MarketListener listener) {
        List<MarketListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void notify(String eventType, Product product, Double price, Integer active) {
        List<MarketListener> users = listeners.get(eventType);
        for (MarketListener listener : users) {
            listener.updateOffers(eventType, product, price, active);
        }
    }
}
