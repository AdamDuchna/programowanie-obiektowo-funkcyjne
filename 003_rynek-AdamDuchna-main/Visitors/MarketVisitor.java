package Visitors;

import Buyer.Buyer;
import Seller.Seller;

public class MarketVisitor implements Visitor {
    public double visit(Buyer buyer){
        return buyer.getIncome();
    }
    public double visit(Seller seller) {
        return seller.getGrossMargin();
    }
}
