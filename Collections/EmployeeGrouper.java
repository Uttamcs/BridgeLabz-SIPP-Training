package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    private String name;
    private String department;
    
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return name;
    }
}

public class EmployeeGrouper {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        
        for (Employee employee : employees) {
            String department = employee.getDepartment();
            
            if (!departmentMap.containsKey(department)) {
                departmentMap.put(department, new ArrayList<>());
            }
            
            departmentMap.get(department).add(employee);
        }
        
        return departmentMap;
    }
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
        employees.add(new Employee("Dave", "Finance"));
        employees.add(new Employee("Eve", "IT"));
        
        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);
        
        System.out.println("Employees grouped by department:");
        for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}