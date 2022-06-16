import Buyer.Buyer;
import CentralBank.CentralBank;
import Managers.BankManager;
import Managers.MarketManager;
import Products.Product;
import Seller.Seller;

import java.util.ArrayList;

public class Simulation {
    public static void main(String[] args) {
        BankManager bankManager = new BankManager();
        MarketManager marketManager = new MarketManager("OFFER","BUY");

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> products2 = new ArrayList<>();
        Product product1 = new Product(26.0);
        Product product2 = new Product(40.0);
        products.add(product1);
        products.add(product2);
        products2.add(product1);



        Seller seller1 = new Seller(products,1.3);
        Seller seller2 = new Seller(products2,1.1);
        Buyer buyer1 = new Buyer(products,200.,10.);
        Buyer buyer2 = new Buyer(products2,10.,10.);
        Buyer buyer3 = new Buyer(products,10.,20.);



        bankManager.subscribe(buyer1);
        bankManager.subscribe(buyer2);
        bankManager.subscribe(buyer3);

        bankManager.subscribe(seller1);
        bankManager.subscribe(seller2);

        CentralBank bank = new CentralBank(1.02,100.);
        bank.setBankManager(bankManager);
        marketManager.subscribe("BUY",bank);
        bank.setMarketManager(marketManager);

        marketManager.subscribe("OFFER",buyer1);
        marketManager.subscribe("BUY",buyer1);
        marketManager.subscribe("OFFER",buyer2);
        marketManager.subscribe("BUY",buyer2);
        marketManager.subscribe("OFFER",buyer3);
        marketManager.subscribe("BUY",buyer3);

        seller1.setBankManager(bankManager);
        seller1.setMarketManager(marketManager);

        seller2.setBankManager(bankManager);
        seller2.setMarketManager(marketManager);

        buyer1.setMarketManager(marketManager);
        buyer2.setMarketManager(marketManager);
        buyer3.setMarketManager(marketManager);
        bank.adjustInflation();
        int counter = 0;
        while(counter<100){
            seller1.sendOffers();
            seller2.sendOffers();
            buyer1.checkOutOffers();
            buyer2.checkOutOffers();
            if(counter%10 == 0 ){bank.resetTurnover();}
            counter++;
        }


    }
}
