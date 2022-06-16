package Cart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import Product.* ;
import Store.*;


public class Cart {
    Store store;
    public ArrayList<Product> myCart = new ArrayList<>();

    public Cart(Store selectedStore) {
        store = selectedStore;
    }

    public void sort(Comparator<Product> comparator) {
        myCart.sort(comparator);
    }

    public ArrayList<Product> getNElements(Integer n) {
        return (ArrayList<Product>) myCart.stream().limit(n).collect(Collectors.toList());
    }

    public void addToCart(String code) {
        Product prod = store.findProductByCode(code);
        if( prod != null) { myCart.add(prod);}
    }

    public void removeFromCart(String code) {
        Product prod = store.findProductByCode(code);
        if( prod != null) { myCart.remove(prod);}
    }

    public Double getCartPrice() {
        Double cartPrice = 0.0;
        for (Product product : myCart) cartPrice += product.getPrice();
        return cartPrice;
    }

}
