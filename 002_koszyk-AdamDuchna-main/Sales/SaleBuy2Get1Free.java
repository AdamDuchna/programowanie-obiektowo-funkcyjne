package Sales;
import Cart.*;
import Product.Product;

import java.util.ArrayList;
import java.util.Comparator;


public class SaleBuy2Get1Free implements Sale {
    @Override
    public Double apply(Cart cart, Double finalPrice) {
        int cartLength = cart.myCart.size();
        int toBeApplied = cartLength / 3;
        cart.sort(Comparator.comparing(Product::getPrice));
        ArrayList<Product> products = cart.getNElements(toBeApplied);
        Double priceReturn = finalPrice;
        for (Product product : products) priceReturn = priceReturn - product.getPrice();
        return finalPrice;
    }
}