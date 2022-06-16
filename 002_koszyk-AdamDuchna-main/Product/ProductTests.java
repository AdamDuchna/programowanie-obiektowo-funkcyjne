package Product;


import static org.junit.jupiter.api.Assertions.*;

public class ProductTests {
    @org.junit.jupiter.api.Test
    void testGetName() {
        Product product1 = new Product("APL01", "Apple", 0.32);
        assertEquals("Apple", product1.getName());
    }

    @org.junit.jupiter.api.Test
    void testGetPrice() {
        Product product1 = new Product("APL01", "Apple", 0.32);
        assertEquals(0.32, product1.getPrice());
    }

    @org.junit.jupiter.api.Test
    void testGetCode() {
        Product product1 = new Product("APL01", "Apple", 0.32);
        assertEquals("APL01", product1.getCode());
    }
}
