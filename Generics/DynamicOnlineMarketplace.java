package Generics;

import java.util.ArrayList;
import java.util.List;

interface Category {
    String getName();
}

class BookCategory implements Category {
    public String getName() { return "Books"; }
}

class ClothingCategory implements Category {
    public String getName() { return "Clothing"; }
}

class GadgetCategory implements Category {
    public String getName() { return "Gadgets"; }
}

class Product<T extends Category> {
    private String id;
    private String name;
    private double price;
    private T category;
    
    public Product(String id, String name, double price, T category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=$" + price + 
               ", category=" + category.getName() + "]";
    }
}

class Catalog {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        double discountFactor = 1 - (percentage / 100);
        product.setPrice(product.getPrice() * discountFactor);
    }
    
    public static <T extends Product<?>> void displayProducts(List<T> products) {
        for (T product : products) {
            System.out.println(product);
        }
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        List<Product<?>> products = new ArrayList<>();
        
        Product<BookCategory> book = new Product<>("B001", "Java Programming", 29.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("C001", "Cotton T-Shirt", 19.99, new ClothingCategory());
        Product<GadgetCategory> headphones = new Product<>("G001", "Wireless Headphones", 99.99, new GadgetCategory());
        
        products.add(book);
        products.add(shirt);
        products.add(headphones);
        
        System.out.println("Products before discount:");
        Catalog.displayProducts(products);
        
        Catalog.applyDiscount(book, 15);
        Catalog.applyDiscount(shirt, 20);
        Catalog.applyDiscount(headphones, 10);
        
        System.out.println("\nProducts after discount:");
        Catalog.displayProducts(products);
    }
}