package Sales;
import Cart.*;
public class SaleFreeCup implements Sale {
    @Override
    public Double apply(Cart cart, Double finalPrice) {

        if (cart.getCartPrice() > 200) {
            System.out.println("You can get a free cup");
            return finalPrice;
        }
        return finalPrice;
    }
}