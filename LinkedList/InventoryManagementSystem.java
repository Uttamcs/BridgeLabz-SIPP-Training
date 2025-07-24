package LinkedList;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagementSystem {
    private Item head;

    public void addItem(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    public void removeItem(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
    }

    public Item searchById(int itemId) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Item searchByName(String itemName) {
        Item current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public double calculateTotalValue() {
        double total = 0;
        Item current = head;
        while (current != null) {
            total += current.quantity * current.price;
            current = current.next;
        }
        return total;
    }

    public void sortByName() {
        if (head == null || head.next == null) return;
        
        boolean swapped;
        do {
            swapped = false;
            Item current = head;
            while (current.next != null) {
                if (current.itemName.compareTo(current.next.itemName) > 0) {
                    // Swap data
                    String tempName = current.itemName;
                    int tempId = current.itemId;
                    int tempQuantity = current.quantity;
                    double tempPrice = current.price;
                    
                    current.itemName = current.next.itemName;
                    current.itemId = current.next.itemId;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;
                    
                    current.next.itemName = tempName;
                    current.next.itemId = tempId;
                    current.next.quantity = tempQuantity;
                    current.next.price = tempPrice;
                    
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        Item current = head;
        while (current != null) {
            System.out.println("ID: " + current.itemId + ", Name: " + current.itemName + 
                             ", Quantity: " + current.quantity + ", Price: $" + current.price);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();
        
        inventory.addItem("Laptop", 101, 10, 999.99);
        inventory.addItem("Mouse", 102, 50, 25.50);
        inventory.addItem("Keyboard", 103, 30, 75.00);
        
        System.out.println("Inventory Items:");
        inventory.displayAll();
        
        System.out.println("\nTotal Inventory Value: $" + inventory.calculateTotalValue());
        
        inventory.sortByName();
        System.out.println("\nAfter sorting by name:");
        inventory.displayAll();
        
        inventory.updateQuantity(102, 45);
        System.out.println("\nAfter updating mouse quantity:");
        inventory.displayAll();
    }
}