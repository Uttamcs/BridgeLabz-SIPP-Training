interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;
    
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

class Chef extends Person implements Worker {
    String specialty;
    
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    
    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is preparing " + specialty + " dishes");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Chef, Specialty: " + specialty);
    }
}

class Waiter extends Person implements Worker {
    int tablesAssigned;
    
    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }
    
    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving " + tablesAssigned + " tables");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Waiter, Tables Assigned: " + tablesAssigned);
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Worker[] workers = {
            new Chef("Gordon", 101, "Italian"),
            new Waiter("Alice", 201, 8),
            new Chef("Maria", 102, "Mexican")
        };
        
        for (Worker worker : workers) {
            if (worker instanceof Person) {
                ((Person) worker).displayInfo();
            }
            worker.performDuties();
            System.out.println();
        }
    }
}