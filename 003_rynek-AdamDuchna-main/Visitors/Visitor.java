package Visitors;

import Buyer.Buyer;
import Seller.Seller;

public interface Visitor {
    double visit(Buyer buyer);
    double visit(Seller seller);
}
