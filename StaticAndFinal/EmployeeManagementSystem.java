public class EmployeeManagementSystem{
    static String companyName = "CapeGemini";
    static int totalEmployees = 0;
    
    String name;
    final int id;
    String designation;
    
    public EmployeeManagementSystem(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }
    
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    
    public void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }
    
    public static void main(String[] args) {
        EmployeeManagementSystem emp1 = new EmployeeManagementSystem("Ram Kumar", 101, "Developer");
        EmployeeManagementSystem emp2 = new EmployeeManagementSystem("Shyam Verma", 102, "Manager");
        
        Object obj = emp1;
        if (obj instanceof EmployeeManagementSystem) {
            ((EmployeeManagementSystem) obj).displayDetails();
        }
        
        EmployeeManagementSystem.displayTotalEmployees();
    }
}