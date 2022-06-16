package CheckOut;

import java.util.ArrayList;
import Cart.*;
import Sales.*;
import Product.* ;
import Store.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckOut {
    Sale sale1 = new SaleBuy2Get1Free();
    Sale sale2 = new Sale30PercentOffPizza();
    Sale sale3 = new SaleFreeCup();
    Sale sale4 = new SaleAbove300();
    Product product1 = new Product("APL01", "Apple", 0.32);
    Product product2 = new Product("APL02", "Apple", 0.52);
    Product product3 = new Product("PZZ01", "Pizza", 14.99);
    Product product4 = new Product("WTR01", "Water", 1.99);
    Product product5 = new Product("CUP01","Cup", 0.00);

    @org.junit.jupiter.api.Test
    void testApplySales() {
        ArrayList<Sale> SALES = new ArrayList<>();
        SALES.add(sale1);
        SALES.add(sale2);
        SALES.add(sale3);
        SALES.add(sale4);
        Store store = new Store();
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        store.addProduct(product4);
        store.addProduct(product5);
        Cart cart = new Cart(store);
        cart.addToCart("APL01");
        cart.addToCart("APL02");
        cart.addToCart("PZZ01");
        cart.addToCart("WTR01");
        CheckOut checkOut = new CheckOut(cart,SALES);

        checkOut.applySales();
        assertEquals(13.003,checkOut.getFinalPrice());
    }
}
