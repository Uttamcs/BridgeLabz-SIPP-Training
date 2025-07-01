import java.util.ArrayList;

class Product {
    String name;
    double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public void displayDetails() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}

class Order {
    int orderID;
    ArrayList<Product> products;
    double totalAmount;
    
    public Order(int orderID) {
        this.orderID = orderID;
        this.products = new ArrayList<>();
        this.totalAmount = 0;
    }
    
    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.price;
    }
    
    public void displayOrder() {
        System.out.println("Order ID: " + orderID + ", Total: $" + totalAmount);
        for (Product product : products) {
            product.displayDetails();
        }
    }
}

class Customer {
    String name;
    ArrayList<Order> orders;
    
    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }
    
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed order " + order.orderID);
    }
    
    public void displayOrders() {
        System.out.println("Customer: " + name);
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Customer customer = new Customer("Sandeep sharma");
        
        Product p1 = new Product("Laptop", 999.99);
        Product p2 = new Product("Mouse", 25.50);
        Product p3 = new Product("Keyboard", 75.00);
        
        Order order1 = new Order(1001);
        order1.addProduct(p1);
        order1.addProduct(p2);
        
        Order order2 = new Order(1002);
        order2.addProduct(p3);
        
        customer.placeOrder(order1);
        customer.placeOrder(order2);
        
        customer.displayOrders();
    }
}