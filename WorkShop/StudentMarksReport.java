import java.util.*;
public class StudentMarksReport{
    private Map<String, List<Integer>> studentMarks;
    
    public StudentMarksReport() {
        studentMarks = new HashMap<>();
    }
    
    public void addMarks(String name, int mark) {
        studentMarks.putIfAbsent(name, new ArrayList<>());
        studentMarks.get(name).add(mark);
    }

    public double calculateAverage(String name) {
        List<Integer> marks = studentMarks.get(name);
        if (marks == null || marks.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    public String getTopper() {
        String topper = null;
        double highestMarks = -1;

        for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
            String name = entry.getKey();
            double average = calculateAverage(name);
            if (average > highestMarks) {
                highestMarks = average;
                topper = name;
            }
        }
        return topper;
    }
    public static void main(String[] args) {
        StudentMarksReport report = new StudentMarksReport();
        report.addMarks("Uttam", 89);
        report.addMarks("Suraj", 98);
        report.addMarks("Suraj", 26);
        report.addMarks("Uttam", 79);
        report.addMarks("Uttam", 95);
        System.out.println("The average marks of Uttam is "+report.calculateAverage("Uttam"));
        System.out.println("The average marks of Suraj is " + report.calculateAverage("Suraj"));
        System.out.println("Topper of the class is "+report.getTopper());
    }
}