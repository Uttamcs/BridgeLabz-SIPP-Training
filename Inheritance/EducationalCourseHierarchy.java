class Course {
    String courseName;
    int duration;
    
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    
    public void displayInfo() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;
    
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform + ", Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;
    
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        double finalFee = fee - (fee * discount / 100);
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%, Final Fee: $" + finalFee);
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Course course1 = new Course("Basic Programming", 40);
        OnlineCourse course2 = new OnlineCourse("Web Development", 80, "Udemy", true);
        PaidOnlineCourse course3 = new PaidOnlineCourse("Advanced Java", 120, "Coursera", false, 299.99, 20);
        
        course1.displayInfo();
        System.out.println();
        
        course2.displayInfo();
        System.out.println();
        
        course3.displayInfo();
    }
}