import java.util.ArrayList;

class Faculty {
    String name;
    String specialization;
    
    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
    
    public void displayDetails() {
        System.out.println("Faculty: " + name + ", Specialization: " + specialization);
    }
}

class Department {
    String deptName;
    ArrayList<Faculty> facultyMembers;
    
    public Department(String deptName) {
        this.deptName = deptName;
        this.facultyMembers = new ArrayList<>();
    }
    
    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }
    
    public void displayFaculty() {
        System.out.println("Department: " + deptName);
        for (Faculty faculty : facultyMembers) {
            faculty.displayDetails();
        }
    }
}

class University {
    String universityName;
    ArrayList<Department> departments;
    
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }
    
    public void addDepartment(Department department) {
        departments.add(department);
    }
    
    public void displayUniversity() {
        System.out.println("University: " + universityName);
        for (Department dept : departments) {
            dept.displayFaculty();
        }
    }
}

public class UniversityFacultyDepartments {
    public static void main(String[] args) {
        University university = new University("GLA University");
        
        Department csDept = new Department("Computer Science");
        Department mathDept = new Department("Mathematics");
        
        Faculty f1 = new Faculty("Dr. Ram", "AI");
        Faculty f2 = new Faculty("Dr. Sohil Khan", "Algorithms");
        Faculty f3 = new Faculty("Dr. HariOm sharma", "Statistics");
        
        csDept.addFaculty(f1);
        csDept.addFaculty(f2);
        mathDept.addFaculty(f3);
        mathDept.addFaculty(f1);
        
        university.addDepartment(csDept);
        university.addDepartment(mathDept);
        
        university.displayUniversity();
    }
}