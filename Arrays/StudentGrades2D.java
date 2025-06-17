import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        
        int[][] marks = new int[numStudents][3]; // [student][subject]
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            
            System.out.print("Enter Physics marks: ");
            marks[i][0] = scanner.nextInt();
            if (marks[i][0] < 0) {
                System.out.println("Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }
            
            System.out.print("Enter Chemistry marks: ");
            marks[i][1] = scanner.nextInt();
            if (marks[i][1] < 0) {
                System.out.println("Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }
            
            System.out.print("Enter Maths marks: ");
            marks[i][2] = scanner.nextInt();
            if (marks[i][2] < 0) {
                System.out.println("Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }
            
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            
            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "F";
            }
        }
        
        System.out.println("\nStudent Results:");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Student %d: Physics: %d, Chemistry: %d, Maths: %d, Percentage: %.2f%%, Grade: %s\n", 
                             (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
        
        scanner.close();
    }
}