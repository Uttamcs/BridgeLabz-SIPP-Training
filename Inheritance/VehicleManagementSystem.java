interface Refuelable {
    void refuel();
}

class Vehicle {
    int maxSpeed;
    String model;
    
    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
    
    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    int batteryCapacity;
    
    public ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }
    
    public void charge() {
        System.out.println("Electric vehicle " + model + " is charging with " + batteryCapacity + "kWh battery");
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Electric Vehicle");
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + "kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacity;
    
    public PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }
    
    @Override
    public void refuel() {
        System.out.println("Petrol vehicle " + model + " is refueling with " + fuelTankCapacity + "L tank");
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Petrol Vehicle");
        super.displayInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + "L");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(200, "Tesla Model 3", 75);
        PetrolVehicle pv = new PetrolVehicle(180, "Honda Civic", 50);
        
        ev.displayInfo();
        ev.charge();
        System.out.println();
        
        pv.displayInfo();
        pv.refuel();
    }
}