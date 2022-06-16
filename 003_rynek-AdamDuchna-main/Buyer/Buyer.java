package Buyer;

import Listeners.BankListener;
import Listeners.MarketListener;
import Managers.MarketManager;
import Products.Product;

import java.util.Random;

import Offer.Offer;
import Visitors.MarketVisitor;
import Visitors.Visitable;
import Visitors.Visitor;

import java.util.ArrayList;

public class Buyer implements MarketListener, BankListener, Visitable {
    private final ArrayList<Product> wantedProducts;
    private Double money;
    private final Double income;
    private final ArrayList<Offer> offers = new ArrayList<>();
    public Double inflation;
    private MarketManager marketManager;
    Random rand = new Random();
    MarketVisitor visitor = new MarketVisitor();


    public Buyer(ArrayList<Product> wantedProducts, Double money, Double income) {
        this.wantedProducts = wantedProducts;
        this.money = money;
        this.income = income;
    }

    public Double getIncome(){return income;}
    public void setMarketManager(MarketManager marketManager){this.marketManager = marketManager;}

    public void updateOffers(String eventType, Product product, Double price, Integer active) {
        if (eventType.equals("BUY")) {
            offers.removeIf(offer -> offer.product == product && offer.price.equals(price));
        } else {
            if (wantedProducts.contains(product)) {
                Offer offer = new Offer(product, price, active);
                offers.add(offer);
                checkOutOffers();
            }
        }
    }

    public void updateInflation(Double inflation) {this.inflation = inflation;}

    public void checkOutOffers() {
        ArrayList<Offer> toBuy = new ArrayList<>();
        offers.removeIf(offer->offer.active<=0);
        Double min = getOfferMin();
        Double max = getOfferMax();
        for (Offer offer : offers) {
            if (rand.nextDouble() < ( ((offer.price - min+ 0.01)/(max - min + 0.01) * 0.8)+0.1)
                    && offer.active > 0 && money >= offer.price) {
                toBuy.add(offer);
            }
            offer.active-=1;
        }
        for ( Offer offer : toBuy){
            System.out.println("======================================================================================");
            System.out.println(this+"bought product "+offer.product+" for "+offer.price);
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Money left in their account:" +money);
            System.out.println("======================================================================================");
            marketManager.notify("BUY", offer.product, offer.price, -1);
            money -= offer.price;
        }
        money += accept(visitor);
    }

    public double accept(Visitor visitor) {return visitor.visit(this);}

    public Double getOfferMax(){
        Double max = Double.NEGATIVE_INFINITY;
        for(Offer offer : offers){ if(offer.price > max){max = offer.price;} }
        return max;
    }

    public Double getOfferMin(){
        Double min = Double.POSITIVE_INFINITY;
        for(Offer offer : offers){ if(offer.price < min){min = offer.price;} }
        return min;
    }

}
