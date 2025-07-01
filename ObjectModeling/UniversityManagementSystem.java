import java.util.ArrayList;

class Course {
    String courseName;
    Professor professor;
    ArrayList<Student> enrolledStudents;
    
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }
    
    public void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.assignCourse(this);
    }
    
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
    
    public void displayCourse() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Professor: " + professor.name);
        }
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
    
    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
        System.out.println(name + " enrolled in " + course.courseName);
    }
    
    public void displayCourses() {
        System.out.println("Student: " + name);
        for (Course course : courses) {
            System.out.println("Enrolled in: " + course.courseName);
        }
    }
}

class Professor {
    String name;
    String department;
    ArrayList<Course> courses;
    
    public Professor(String name, String department) {
        this.name = name;
        this.department = department;
        this.courses = new ArrayList<>();
    }
    
    public void assignCourse(Course course) {
        courses.add(course);
    }
    
    public void displayCourses() {
        System.out.println("Professor: " + name + " (" + department + ")");
        for (Course course : courses) {
            System.out.println("Teaching: " + course.courseName);
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student("Sam", 101);
        Student s2 = new Student("curran", 102);
        
        Professor p1 = new Professor("Dr. Ajitesh", "Computer Science");
        Professor p2 = new Professor("Dr. Anand", "Mathematics");
        
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Calculus");
        
        c1.assignProfessor(p1);
        c2.assignProfessor(p2);
        
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);
        
        s1.displayCourses();
        p1.displayCourses();
        c1.displayCourse();
    }
}