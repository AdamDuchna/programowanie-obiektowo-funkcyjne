package Sales;
import Cart.*;
import Product.*;

public class Sale30PercentOffPizza implements Sale {
    @Override
    public Double apply(Cart cart, Double finalPrice) {
        Double salePrice = 0.0;
        for (Product product : cart.myCart) {
            if (product.getCode().equals("PZZ01")) {
                salePrice = product.getPrice() * 0.3;
                break;
            }
        }
        return finalPrice - salePrice;
    }
}
