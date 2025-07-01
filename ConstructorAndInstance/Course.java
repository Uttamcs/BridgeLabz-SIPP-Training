public class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "Tech Institute";
    
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    
    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months, Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }
    
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }
    
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 6, 500);
        Course c2 = new Course("Data Science", 12, 1200);
        
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        
        Course.updateInstituteName("Advanced Tech Academy");
        System.out.println("\nAfter updating institute name:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}