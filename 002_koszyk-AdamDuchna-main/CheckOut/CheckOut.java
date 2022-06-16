package CheckOut;

import java.util.ArrayList;
import Cart.Cart;
import Sales.Sale;

public class CheckOut {
    Cart checkoutCart;
    ArrayList<Sale> salesToApply;
    Double finalPrice;

    CheckOut(Cart cart, ArrayList<Sale> SALES) {
        salesToApply = SALES;
        checkoutCart = cart;
        finalPrice = cart.getCartPrice();
    }

    public void applySales() {
        for (Sale sale : salesToApply) {
            finalPrice = sale.apply(checkoutCart, finalPrice);
        }
    }

    public Double getFinalPrice() {
        return finalPrice;
    }
}
