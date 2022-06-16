package Sales;
import Cart.*;
public class SaleAbove300 implements Sale {
    @Override
    public Double apply(Cart cart, Double finalPrice) {
        if( cart.getCartPrice() > 300 ) return finalPrice * 0.95;
        return finalPrice;
    }
}
