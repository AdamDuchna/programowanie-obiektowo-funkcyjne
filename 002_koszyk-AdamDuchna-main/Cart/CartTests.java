package Cart;

import org.junit.jupiter.api.Test;
import Product.* ;
import Store.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CartTests {
    Product product1 = new Product("APL01", "Apple", 0.32);
    Product product2 = new Product("APL02", "Apple", 0.52);
    Product product3 = new Product("PZZ01", "Pizza", 14.99);
    Product product4 = new Product("WTR01", "Water", 1.99);
    Store store = new Store();

    @org.junit.jupiter.api.Test
    void testAddToCart() {
        ArrayList<Product> wzk = new ArrayList<>();
        wzk.add(product1);
        wzk.add(product2);
        store.addProduct(product1);
        store.addProduct(product2);
        Cart cart = new Cart(store);
        cart.addToCart("APL01");
        cart.addToCart("APL02");
        assertEquals(wzk, cart.getNElements(2));
    }

    @org.junit.jupiter.api.Test
    void testRemoveFromCart() {
        ArrayList<Product> wzk = new ArrayList<>();
        wzk.add(product4);
        store.addProduct(product3);
        store.addProduct(product4);
        Cart cart = new Cart(store);
        cart.addToCart("WTR01");
        cart.addToCart("PZZ01");
        cart.removeFromCart("PZZ01");
        assertEquals(wzk, cart.getNElements(1));
    }

    @org.junit.jupiter.api.Test
    void testGetCartPrice() {
        store.addProduct(product3);
        store.addProduct(product4);
        Cart cart = new Cart(store);
        cart.addToCart("WTR01");
        cart.addToCart("PZZ01");
        assertEquals(16.98, cart.getCartPrice());
    }

    @Test
    void testAddWrongToCart() {
        ArrayList<Product> wzk = new ArrayList<>();
        wzk.add(product2);
        store.addProduct(product1);
        store.addProduct(product2);
        Cart cart = new Cart(store);
        cart.addToCart("APL03");
        cart.addToCart("APL02");
        assertEquals(wzk, cart.getNElements(1));
    }
}
