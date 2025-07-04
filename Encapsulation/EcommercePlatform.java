interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public abstract double calculateDiscount();
    
    public double getFinalPrice() {
        double tax = (this instanceof Taxable) ? ((Taxable) this).calculateTax() : 0;
        return price + tax - calculateDiscount();
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }
    
    @Override
    public String getTaxDetails() {
        return "GST 18%";
    }
}

class Clothing extends Product {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }
}

class Groceries extends Product implements Taxable {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }
    
    @Override
    public String getTaxDetails() {
        return "GST 5%";
    }
}

public class EcommercePlatform {
    public static void calculateFinalPrice(Product[] products) {
        for (Product product : products) {
            System.out.println(product.getName() + " - Final Price: $" + product.getFinalPrice());
        }
    }
    
    public static void main(String[] args) {
        Product[] products = {
            new Electronics(1, "Laptop", 1000),
            new Clothing(2, "Shirt", 50),
            new Groceries(3, "Rice", 20)
        };
        
        calculateFinalPrice(products);
    }
}