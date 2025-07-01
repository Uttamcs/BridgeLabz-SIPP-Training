import java.util.ArrayList;

class Employee {
    String name;
    int id;
    
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public void displayDetails() {
        System.out.println("Employee: " + name + ", ID: " + id);
    }
}

class Department {
    String deptName;
    ArrayList<Employee> employees;
    
    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }
    
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    public void displayEmployees() {
        System.out.println("Department: " + deptName);
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}

class Company {
    String companyName;
    ArrayList<Department> departments;
    
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }
    
    public void addDepartment(Department department) {
        departments.add(department);
    }
    
    public void displayCompany() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayEmployees();
        }
    }
}

public class CompanyAndDepartments {
    public static void main(String[] args) {
        Company company = new Company("Josh Technology Group");
        
        Department itDept = new Department("IT");
        Department hrDept = new Department("HR");
        
        Employee emp1 = new Employee("Sameer", 101);
        Employee emp2 = new Employee("Suraj", 102);
        Employee emp3 = new Employee("Suruchi", 201);
        
        itDept.addEmployee(emp1);
        itDept.addEmployee(emp2);
        hrDept.addEmployee(emp3);
        
        company.addDepartment(itDept);
        company.addDepartment(hrDept);
        
        company.displayCompany();
    }
}