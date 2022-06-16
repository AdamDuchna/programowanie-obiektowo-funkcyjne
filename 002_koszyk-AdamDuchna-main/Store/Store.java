package Store;

import java.util.HashMap;
import java.util.Map;
import Product.*;

public class Store {
    private final Map<String, Product> PRODUCTS;
    public Store(){
        PRODUCTS = new HashMap<>();
    }
    public void addProduct(Product product) {
        PRODUCTS.put(product.getCode(), product);
    }

    public Product findProductByCode(String code) {
        return PRODUCTS.get(code);
    }

    public void  removeProductByCode(String code) {
        PRODUCTS.remove(code);
    }

}
