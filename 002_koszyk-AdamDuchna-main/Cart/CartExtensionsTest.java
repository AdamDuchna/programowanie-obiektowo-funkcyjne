package Cart;

import java.util.ArrayList;
import Product.* ;
import Store.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartExtensionsTest {
    Product product1 = new Product("APL01", "Apple", 0.32);
    Product product2 = new Product("APL02", "Apple", 0.52);
    Product product3 = new Product("PZZ01", "Pizza", 14.99);
    Product product4 = new Product("WTR01", "Water", 1.99);
    Store store = new Store();
    @org.junit.jupiter.api.Test
    void testFindCheapest() {
        store.addProduct(product3);
        store.addProduct(product4);
        CartExtensions cart = new CartExtensions(store);
        cart.addToCart("WTR01");
        cart.addToCart("PZZ01");
        assertEquals(product4, cart.findCheapest());
    }

    @org.junit.jupiter.api.Test
    void testFindPriciest() {
        store.addProduct(product3);
        store.addProduct(product4);
        CartExtensions cart = new CartExtensions(store);
        cart.addToCart("WTR01");
        cart.addToCart("PZZ01");
        assertEquals(product3, cart.findPriciest());
    }

    @org.junit.jupiter.api.Test
    void testFindNPriciest() {
        ArrayList<Product> wzk = new ArrayList<>();
        wzk.add(product2);
        wzk.add(product1);
        store.addProduct(product1);
        store.addProduct(product2);
        CartExtensions cart = new CartExtensions(store);
        cart.addToCart("APL01");
        cart.addToCart("APL02");
        assertEquals(wzk, cart.findNPriciest(2));
    }

    @org.junit.jupiter.api.Test
    void testFindNCheapest() {
        ArrayList<Product> wzk = new ArrayList<>();
        wzk.add(product1);
        wzk.add(product2);
        store.addProduct(product1);
        store.addProduct(product2);
        CartExtensions cart = new CartExtensions(store);
        cart.addToCart("APL01");
        cart.addToCart("APL02");
        assertEquals(wzk, cart.findNCheapest(2));
    }

    @org.junit.jupiter.api.Test
    void testSortPriceName() {
        ArrayList<Product> wzk = new ArrayList<>();
        wzk.add(product1);
        wzk.add(product2);
        wzk.add(product3);
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        CartExtensions cart = new CartExtensions(store);
        cart.addToCart("APL01");
        cart.addToCart("APL02");
        cart.addToCart("PZZ01");
        cart.sortByPriceAndName();
        assertEquals(wzk, cart.findNCheapest(3));
    }
}
