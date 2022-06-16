package Product;

public class Product {
    private final String code;
    private final String name;
    private final Double price;

    public Product(String inputCode, String inputName, Double inputPrice) {
        code = inputCode;
        name = inputName;
        price = inputPrice;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }


}
