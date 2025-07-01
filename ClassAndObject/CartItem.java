public class CartItem {
    String itemName;
    double price;
    int quantity;
    
    public CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }
    
    public void addItem(int quantity) {
        this.quantity += quantity;
        System.out.println("Added " + quantity + " " + itemName + "(s) to cart");
    }
    
    public void removeItem(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
            System.out.println("Removed " + quantity + " " + itemName + "(s) from cart");
        } else {
            System.out.println("Cannot remove more items than available in cart");
        }
    }
    
    public double calculateTotalCost() {
        return price * quantity;
    }
    
    public void displayCartDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
    
    public static void main(String[] args) {
        CartItem item1 = new CartItem("Laptop", 999.99);
        CartItem item2 = new CartItem("Mouse", 25.50);
        
        item1.addItem(2);
        item1.displayCartDetails();
        System.out.println();
        
        item2.addItem(5);
        item2.removeItem(2);
        item2.displayCartDetails();
    }
}