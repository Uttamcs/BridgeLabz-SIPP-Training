public class Item {
    String itemCode;
    String itemName;
    double price;
    
    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    
    public void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
    }
    
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
    
    public static void main(String[] args) {
        Item item1 = new Item("I001", "Laptop", 999.99);
        Item item2 = new Item("I002", "Mouse", 25.50);
        
        item1.displayItemDetails();
        System.out.println("Total cost for 2 units: $" + item1.calculateTotalCost(2));
        System.out.println();
        
        item2.displayItemDetails();
        System.out.println("Total cost for 5 units: $" + item2.calculateTotalCost(5));
    }
}