public class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void displayDetails() {
        System.out.println("ID: " + employeeID + ", Department: " + department + ", Salary: $" + salary);
    }
}

class Manager extends Employee {
    int teamSize;
    
    public Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }
    
    public void displayManagerDetails() {
        System.out.println("ID: " + employeeID + ", Department: " + department + ", Salary: $" + getSalary() + ", Team Size: " + teamSize);
    }
    
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "IT", 60000);
        Manager mgr1 = new Manager(201, "Engineering", 90000, 10);
        
        emp1.displayDetails();
        mgr1.displayManagerDetails();
        
        emp1.setSalary(65000);
        System.out.println("Updated Salary: $" + emp1.getSalary());
    }
}