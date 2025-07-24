package Generics;

import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String evaluationMethod;
    
    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }
    
    public String getEvaluationMethod() { return evaluationMethod; }
    
    public abstract String getDescription();
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
    
    @Override
    public String getDescription() {
        return "Course evaluated through written exams";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
    
    @Override
    public String getDescription() {
        return "Course evaluated through practical assignments";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
    
    @Override
    public String getDescription() {
        return "Course evaluated through research papers";
    }
}

class Course<T extends CourseType> {
    private String courseId;
    private String courseName;
    private String department;
    private T courseType;
    
    public Course(String courseId, String courseName, String department, T courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }
    
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getDepartment() { return department; }
    public T getCourseType() { return courseType; }
    
    @Override
    public String toString() {
        return "Course [id=" + courseId + ", name=" + courseName + ", department=" + department + 
               ", evaluation=" + courseType.getEvaluationMethod() + "]";
    }
}

class Department {
    private String name;
    private List<Course<?>> courses = new ArrayList<>();
    
    public Department(String name) {
        this.name = name;
    }
    
    public void addCourse(Course<?> course) {
        courses.add(course);
    }
    
    public List<Course<?>> getCourses() {
        return courses;
    }
    
    public static void displayCourses(List<? extends Course<?>> courses) {
        for (Course<?> course : courses) {
            System.out.println(course + " - " + course.getCourseType().getDescription());
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        Department computerScience = new Department("Computer Science");
        Department mathematics = new Department("Mathematics");
        
        Course<ExamCourse> algorithms = new Course<>("CS101", "Algorithms", "Computer Science", new ExamCourse());
        Course<AssignmentCourse> webDev = new Course<>("CS202", "Web Development", "Computer Science", new AssignmentCourse());
        Course<ResearchCourse> thesis = new Course<>("CS400", "Thesis", "Computer Science", new ResearchCourse());
        Course<ExamCourse> calculus = new Course<>("MATH101", "Calculus", "Mathematics", new ExamCourse());
        
        computerScience.addCourse(algorithms);
        computerScience.addCourse(webDev);
        computerScience.addCourse(thesis);
        mathematics.addCourse(calculus);
        
        System.out.println("Computer Science Courses:");
        Department.displayCourses(computerScience.getCourses());
        
        System.out.println("\nMathematics Courses:");
        Department.displayCourses(mathematics.getCourses());
    }
}