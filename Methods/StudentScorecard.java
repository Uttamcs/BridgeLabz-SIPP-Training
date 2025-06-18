import java.util.Scanner;

public class StudentScorecard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        
        int[][] scores = generateRandomScores(numStudents);
        double[][] results = calculateResults(scores);
        
        displayScorecard(scores, results);
        
        sc.close();
    }
    
    public static int[][] generateRandomScores(int numStudents) {
        int[][] scores = new int[numStudents][3]; // Physics, Chemistry, Math
        
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + (int)(Math.random() * 90); // Random score between 10-99
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
    
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("\nStudent Scorecard:");
        System.out.println("Student\tPhysics\tChem\tMath\tTotal\tAvg\tPercentage");
        System.out.println("-------------------------------------------------------");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%%\n", 
                             (i + 1), scores[i][0], scores[i][1], scores[i][2], 
                             results[i][0], results[i][1], results[i][2]);
        }
    }
}