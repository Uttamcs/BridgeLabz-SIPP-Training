package Generics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String id;
    private String name;
    
    public WarehouseItem(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + ", name=" + name + "]";
    }
}

class Electronics extends WarehouseItem {
    private double voltage;
    
    public Electronics(String id, String name, double voltage) {
        super(id, name);
        this.voltage = voltage;
    }
    
    public double getVoltage() { return voltage; }
}

class Groceries extends WarehouseItem {
    private String expiryDate;
    
    public Groceries(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }
    
    public String getExpiryDate() { return expiryDate; }
}

class Furniture extends WarehouseItem {
    private String material;
    
    public Furniture(String id, String name, String material) {
        super(id, name);
        this.material = material;
    }
    
    public String getMaterial() { return material; }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    
    public void addItem(T item) {
        items.add(item);
    }
    
    public T getItem(String id) {
        for (T item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
    
    public List<T> getAllItems() {
        return items;
    }
    
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E001", "Laptop", 19.5));
        electronicsStorage.addItem(new Electronics("E002", "Smartphone", 5.0));
        
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G001", "Milk", "2023-12-31"));
        groceriesStorage.addItem(new Groceries("G002", "Bread", "2023-12-15"));
        
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F001", "Chair", "Wood"));
        
        System.out.println("Electronics:");
        Storage.displayItems(electronicsStorage.getAllItems());
        
        System.out.println("\nGroceries:");
        Storage.displayItems(groceriesStorage.getAllItems());
        
        System.out.println("\nFurniture:");
        Storage.displayItems(furnitureStorage.getAllItems());
    }
}