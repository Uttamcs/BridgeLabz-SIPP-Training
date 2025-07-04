class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayRole() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Teacher extends Person {
    String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    @Override
    public void displayRole() {
        super.displayRole();
        System.out.println("Role: Teacher, Subject: " + subject);
    }
}

class Student extends Person {
    String grade;
    
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    
    @Override
    public void displayRole() {
        super.displayRole();
        System.out.println("Role: Student, Grade: " + grade);
    }
}

class Staff extends Person {
    String department;
    
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    
    @Override
    public void displayRole() {
        super.displayRole();
        System.out.println("Role: Staff, Department: " + department);
    }
}

public class SchoolSystemRoles {
    public static void main(String[] args) {
        Person[] people = {
            new Teacher("Dr. Smith", 45, "Mathematics"),
            new Student("Alice Johnson", 16, "10th Grade"),
            new Staff("Bob Wilson", 35, "Administration")
        };
        
        for (Person person : people) {
            person.displayRole();
            System.out.println();
        }
    }
}