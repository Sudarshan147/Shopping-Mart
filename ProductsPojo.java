
package Emart.pojo;


public class ProductsPojo {
    public ProductsPojo()
    {
        
    }

    public ProductsPojo(String productId, String productName, String productCompony, double productsPrice, double ourPrice, int tax, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productCompony = productCompony;
        this.productsPrice = productsPrice;
        this.ourPrice = ourPrice;
        this.tax = tax;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCompony() {
        return productCompony;
    }

    public void setProductCompony(String productCompony) {
        this.productCompony = productCompony;
    }

    public double getProductsPrice() {
        return productsPrice;
    }

    public void setProductsPrice(double productsPrice) {
        this.productsPrice = productsPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   private String productId;
   private String productName;
   private String productCompony;
   private double productsPrice;
   private double ourPrice;
   private int tax;
   private int quantity;
   private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
}
