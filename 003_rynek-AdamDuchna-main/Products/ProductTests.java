package Products;

import static org.junit.jupiter.api.Assertions.*;
public class ProductTests {
    Product prod = new Product(12.3);
    @org.junit.jupiter.api.Test
    public void testPrice(){
        assertEquals(12.3,prod.getProductionPrice());
    }
    @org.junit.jupiter.api.Test
    public void testInflate(){
        prod.inflate(1.2);
        assertEquals(14.76,prod.getProductionPrice());
    }
}
