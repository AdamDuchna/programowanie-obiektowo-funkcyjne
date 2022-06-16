package Store;
import Product.*;
import static org.junit.jupiter.api.Assertions.*;


class StoreTests {
    @org.junit.jupiter.api.Test
    void testAddFindProduct() {
        Product product1 = new Product("APL02", "Apple", 0.52);
        Store store = new Store();
        store.addProduct(product1);
        assertEquals(product1, store.findProductByCode("APL02"));
    }

    @org.junit.jupiter.api.Test
    void testAddDeleteFindProduct() {
        Product product1 = new Product("APL02", "Apple", 0.52);
        Store store = new Store();
        store.addProduct(product1);
        store.removeProductByCode("APL02");
        assertNull(store.findProductByCode("APL02"));
    }
}
