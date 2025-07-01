public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;
    
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    
    public double getCGPA() {
        return CGPA;
    }
    
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
    
    public void displayDetails() {
        System.out.println("Roll: " + rollNumber + ", Name: " + name + ", CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    String specialization;
    
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }
    
    public void displayPGDetails() {
        System.out.println("Roll: " + rollNumber + ", Name: " + name + ", CGPA: " + getCGPA() + ", Specialization: " + specialization);
    }
    
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", 8.5);
        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Bob", 9.2, "Computer Science");
        
        s1.displayDetails();
        pg1.displayPGDetails();
        
        s1.setCGPA(8.8);
        System.out.println("Updated CGPA: " + s1.getCGPA());
    }
}