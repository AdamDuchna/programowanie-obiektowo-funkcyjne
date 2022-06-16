package Visitors;
import Buyer.Buyer;
import Products.Product;
import Seller.Seller;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class VisitorTests {
    ArrayList<Product> arr = new ArrayList<>();
    Seller seller1 = new Seller(arr,1.3);
    Buyer buyer1 = new Buyer(arr,200.,10.);
    MarketVisitor visitor = new MarketVisitor();
    @org.junit.jupiter.api.Test
    public void testBuyer(){
    assertEquals(10,visitor.visit(buyer1));
    }
    @org.junit.jupiter.api.Test
    public void testSeller(){
        assertEquals(1.3,visitor.visit(seller1));
    }
}
