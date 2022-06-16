package Offer;

import Products.Product;

public class Offer {
    public Product product;
    public Integer active;
    public Double price;
    public Offer(Product product, Double price ,Integer active){
        this.product = product;
        this.active = active;
        this.price = price;
    }
}
