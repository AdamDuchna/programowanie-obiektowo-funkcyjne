package CentralBank;

import Listeners.MarketListener;
import Managers.BankManager;
import Managers.MarketManager;
import Products.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CentralBank implements MarketListener {
    private Double inflation;
    private Double turnover = 0.;
    private final Double targetValue;
    public BankManager bankManager;
    public MarketManager marketManager;

    public Double round1(Double val) {
        return new BigDecimal(val.toString()).setScale(1, RoundingMode.UP).doubleValue();
    }

    public CentralBank(Double inflation, Double targetValue){
        this.inflation = inflation;
        this.targetValue = round1(targetValue);
    }
    public void setMarketManager(MarketManager marketManager){this.marketManager = marketManager;}

    public void setBankManager(BankManager bankManager){this.bankManager = bankManager;}

    public void updateOffers(String eventType, Product product, Double price, Integer active) {
        this.turnover += price;
        this.turnover = round1(turnover);
        adjustInflation();
    }
    public void adjustInflation(){

        if( turnover < targetValue){inflation+=0.3;}
        else{inflation-= 0.1;}
        System.out.println("!!-----!!-----!!");
        System.out.println("----INFLATION----");
        System.out.println(-(1.-inflation)*100+"%");
        System.out.println("----TURNOVER----");
        System.out.println(turnover);
        System.out.println("----------------");
        System.out.println("!!-----!!-----!!");
        bankManager.notify(inflation);
    }

    public void resetTurnover(){turnover=0.;}


}
