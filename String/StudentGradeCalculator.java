import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        
        int[][] scores = generateRandomScores(numStudents);
        double[][] results = calculateResults(scores);
        String[][] grades = calculateGrades(results);
        
        displayScorecard(scores, results, grades);
        
        sc.close();
    }
    
    public static int[][] generateRandomScores(int numStudents) {
        int[][] scores = new int[numStudents][3]; // Physics, Chemistry, Math
        
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 40 + (int)(Math.random() * 60); // Random score between 40-99
            }
        }
        
        return scores;
    }
    
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3]; // Total, Average, Percentage
        
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            
            results[i][0] = Math.round(total * 100) / 100.0;
            results[i][1] = Math.round(average * 100) / 100.0;
            results[i][2] = Math.round(percentage * 100) / 100.0;
        }
        
        return results;
    }
    
    public static String[][] calculateGrades(double[][] results) {
        String[][] grades = new String[results.length][1];
        
        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];
            
            if (percentage >= 90) {
                grades[i][0] = "A+";
            } else if (percentage >= 80) {
                grades[i][0] = "A";
            } else if (percentage >= 70) {
                grades[i][0] = "B+";
            } else if (percentage >= 60) {
                grades[i][0] = "B";
            } else if (percentage >= 50) {
                grades[i][0] = "C";
            } else if (percentage >= 40) {
                grades[i][0] = "D";
            } else {
                grades[i][0] = "F";
            }
        }
        
        return grades;
    }
    
    public static void displayScorecard(int[][] scores, double[][] results, String[][] grades) {
        System.out.println("\nStudent Scorecard:");
        System.out.println("Student\tPhysics\tChem\tMath\tTotal\tAvg\tPercentage\tGrade");
        System.out.println("----------------------------------------------------------------------");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%%\t\t%s\n", 
                             (i + 1), scores[i][0], scores[i][1], scores[i][2], 
                             results[i][0], results[i][1], results[i][2], grades[i][0]);
        }
    }
}