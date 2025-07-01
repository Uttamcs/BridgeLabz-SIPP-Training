public class Student {
    String name;
    int rollNumber;
    double marks;
    
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    
    public char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
    
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 101, 85.5);
        Student s2 = new Student("Bob", 102, 92.0);
        
        s1.displayDetails();
        System.out.println();
        s2.displayDetails();
    }
}