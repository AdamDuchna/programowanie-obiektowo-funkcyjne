package Seller;

import Listeners.BankListener;
import Managers.BankManager;
import Managers.MarketManager;
import Products.Product;
import Visitors.MarketVisitor;
import Visitors.Visitable;
import Visitors.Visitor;
import java.util.ArrayList;
import java.util.Random;

public class Seller implements BankListener, Visitable {
    private final ArrayList<Product> products;
    private final Double grossMargin;
    public BankManager bankManager;
    public MarketManager marketManager;
    Random rand = new Random();
    MarketVisitor visitor = new MarketVisitor();
    public Seller(ArrayList<Product> products, Double grossMargin){
        this.products = products;
        this.grossMargin = grossMargin;
    }

    public void setMarketManager(MarketManager marketManager){this.marketManager = marketManager;}

    public void setBankManager(BankManager bankManager){this.bankManager = bankManager;}

    public void updateInflation(Double inflation){ for(Product product : products){ product.inflate(inflation); } }

    public Double getGrossMargin(){ return grossMargin; }

    public void sendOffers(){


        for(Product product : products){
            if(rand.nextDouble()>0.8){
                if(product.getProductionPrice()*accept(visitor) != Double.POSITIVE_INFINITY){
                    System.out.println(this+" offered "+product+" for "+product.getProductionPrice()*accept(visitor));
                    marketManager.notify("OFFER",product, product.getProductionPrice()*accept(visitor)+0.00,rand.nextInt(6));
                }
        }
        }
    }
    public double accept(Visitor visitor) {return visitor.visit(this);}
}
