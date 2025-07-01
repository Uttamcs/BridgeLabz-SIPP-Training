import java.util.ArrayList;

class Course {
    String courseName;
    ArrayList<Student> enrolledStudents;
    
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }
    
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
    
    public void displayEnrolledStudents() {
        System.out.println("Course: " + courseName);
        for (Student student : enrolledStudents) {
            System.out.println("Student: " + student.name);
        }
    }
}

class Student {
    String name;
    int rollNumber;
    ArrayList<Course> courses;
    
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.courses = new ArrayList<>();
    }
    
    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }
    
    public void displayCourses() {
        System.out.println("Student: " + name);
        for (Course course : courses) {
            System.out.println("Enrolled in: " + course.courseName);
        }
    }
}

class School {
    String schoolName;
    ArrayList<Student> students;
    
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public void displayStudents() {
        System.out.println("School: " + schoolName);
        for (Student student : students) {
            System.out.println("Student: " + student.name);
        }
    }
}

public class SchoolStudentsCourses {
    public static void main(String[] args) {
        School school = new School("Doon Senior Secondary School");
        
        Student s1 = new Student("Uttam", 101);
        Student s2 = new Student("Atul", 102);
        
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");
        
        s1.enrollInCourse(c1);
        s1.enrollInCourse(c2);
        s2.enrollInCourse(c1);
        
        school.addStudent(s1);
        school.addStudent(s2);
        
        school.displayStudents();
        s1.displayCourses();
        c1.displayEnrolledStudents();
    }
}