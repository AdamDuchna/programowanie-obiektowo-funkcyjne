package Sales;
import Cart.*;

public interface Sale {
    Double apply(Cart cart, Double finalPrice);
}
