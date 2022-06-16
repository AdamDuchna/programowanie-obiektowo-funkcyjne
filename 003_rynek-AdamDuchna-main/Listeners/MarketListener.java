package Listeners;

import Products.Product;

public interface MarketListener {
    void updateOffers(String eventType, Product product, Double price, Integer active);
}
