class Order {
    String orderId;
    String orderDate;
    
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    
    public String getOrderStatus() {
        return "Order Placed";
    }
    
    public void displayInfo() {
        System.out.println("Order ID: " + orderId + ", Date: " + orderDate + ", Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {
    String trackingNumber;
    
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    
    @Override
    public String getOrderStatus() {
        return "Shipped";
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;
    
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    
    @Override
    public String getOrderStatus() {
        return "Delivered";
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        Order order1 = new Order("ORD001", "2024-01-15");
        ShippedOrder order2 = new ShippedOrder("ORD002", "2024-01-16", "TRK123456");
        DeliveredOrder order3 = new DeliveredOrder("ORD003", "2024-01-17", "TRK789012", "2024-01-20");
        
        order1.displayInfo();
        System.out.println();
        
        order2.displayInfo();
        System.out.println();
        
        order3.displayInfo();
    }
}