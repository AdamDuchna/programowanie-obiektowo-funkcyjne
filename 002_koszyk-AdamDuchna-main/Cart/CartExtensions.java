package Cart;

import java.util.ArrayList;
import java.util.Comparator;
import Store.*;
import Product.* ;


public class CartExtensions extends Cart {
    public CartExtensions(Store store) {
        super(store);
    }

    public Product findCheapest() {
        sort(Comparator.comparing(Product::getPrice));
        return getNElements(1).get(0);
    }

    public Product findPriciest() {
        sort(Comparator.comparing(Product::getPrice).reversed());
        return getNElements(1).get(0);
    }

    public ArrayList<Product> findNCheapest(Integer n) {
        sort(Comparator.comparing(Product::getPrice));
        return getNElements(n);
    }

    public ArrayList<Product> findNPriciest(Integer n) {
        sort(Comparator.comparing(Product::getPrice).reversed());
        return getNElements(n);
    }

    public void sortByPriceAndName() {
        sort(Comparator.comparing(Product::getPrice).thenComparing(Product::getName));
    }
}
