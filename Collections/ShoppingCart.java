package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cartItems = new LinkedHashMap<>();
    
    public void addProductPrice(String product, double price) {
        productPrices.put(product, price);
    }
    
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            throw new IllegalArgumentException("Product not found in catalog");
        }
        
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }
    
    public void removeFromCart(String product) {
        cartItems.remove(product);
    }
    
    public double calculateTotal() {
        double total = 0;
        
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            
            total += price * quantity;
        }
        
        return total;
    }
    
    public Map<String, Integer> getCartInOrderAdded() {
        return cartItems;
    }
    
    public Map<Double, String> getCartSortedByPrice() {
        Map<Double, String> sortedCart = new TreeMap<>();
        
        for (String product : cartItems.keySet()) {
            sortedCart.put(productPrices.get(product), product);
        }
        
        return sortedCart;
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        // Add product prices
        cart.addProductPrice("Laptop", 999.99);
        cart.addProductPrice("Mouse", 19.99);
        cart.addProductPrice("Keyboard", 49.99);
        cart.addProductPrice("Monitor", 199.99);
        
        // Add items to cart
        cart.addToCart("Laptop", 1);
        cart.addToCart("Mouse", 2);
        cart.addToCart("Keyboard", 1);
        
        System.out.println("Cart Items (in order added):");
        for (Map.Entry<String, Integer> entry : cart.getCartInOrderAdded().entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue() + 
                             " - $" + (cart.productPrices.get(entry.getKey()) * entry.getValue()));
        }
        
        System.out.println("\nCart Items (sorted by price):");
        for (Map.Entry<Double, String> entry : cart.getCartSortedByPrice().entrySet()) {
            System.out.println(entry.getValue() + " - $" + entry.getKey());
        }
        
        System.out.println("\nTotal: $" + cart.calculateTotal());
    }
}