public class ShoppingCartSystem{
    static double discount = 10.0;
    
    String productName;
    double price;
    int quantity;
    final String productID;
    
    public ShoppingCartSystem(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }
    
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    
    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }
    
    public static void main(String[] args) {
        ShoppingCartSystem prod1 = new ShoppingCartSystem("Laptop", 999.99, 5, "P001");
        ShoppingCartSystem prod2 = new ShoppingCartSystem("Mouse", 25.50, 20, "P002");
        
        Object obj = prod1;
        if (obj instanceof ShoppingCartSystem) {
            ((ShoppingCartSystem) obj).displayDetails();
        }
        
        ShoppingCartSystem.updateDiscount(15.0);
        System.out.println("Updated discount: " + ShoppingCartSystem.discount + "%");
    }
}