package Products;

public class Product{
    private Double productionPrice;
    public Product(Double productionPrice){
        this.productionPrice = productionPrice;
    }

    public void inflate(Double ratio) {
        productionPrice = productionPrice*ratio;
    }

    public Double getProductionPrice() {
        return productionPrice;
    }
}
