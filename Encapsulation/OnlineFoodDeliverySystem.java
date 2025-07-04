interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public abstract double calculateTotalPrice();
    
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
    
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }
    
    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 5;
    }
    
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }
    
    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5%";
    }
}

public class OnlineFoodDeliverySystem {
    public static void processOrder(FoodItem[] items) {
        double totalBill = 0;
        for (FoodItem item : items) {
            double itemTotal = item.calculateTotalPrice();
            double discount = (item instanceof Discountable) ? ((Discountable) item).applyDiscount() : 0;
            double finalPrice = itemTotal - discount;
            
            System.out.println(item.getItemName() + " - Final Price: $" + finalPrice);
            totalBill += finalPrice;
        }
        System.out.println("Total Bill: $" + totalBill);
    }
    
    public static void main(String[] args) {
        FoodItem[] items = {
            new VegItem("Paneer Curry", 12, 2),
            new NonVegItem("Chicken Biryani", 15, 1),
            new VegItem("Dal Tadka", 8, 3)
        };
        
        processOrder(items);
    }
}