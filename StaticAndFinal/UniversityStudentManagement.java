public class UniversityStudentManagement{
    static String universityName = "GLA University, Mathura";
    static int totalStudents = 0;
    
    String name;
    final int rollNumber;
    char grade;
    
    public UniversityStudentManagement(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    
    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
    
    public void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
    
    public static void main(String[] args) {
        UniversityStudentManagement std1 = new UniversityStudentManagement("Sapna Roy", 2001, 'A');
        UniversityStudentManagement std2 = new UniversityStudentManagement("Suraj Kumar", 2002, 'B');
        
        Object obj = std1;
        if (obj instanceof UniversityStudentManagement) {
            ((UniversityStudentManagement) obj).displayDetails();
        }
        
        UniversityStudentManagement.displayTotalStudents();
    }
}