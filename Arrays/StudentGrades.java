import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        
        double[] physics = new double[numStudents];
        double[] chemistry = new double[numStudents];
        double[] maths = new double[numStudents];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            
            System.out.print("Enter Physics marks: ");
            physics[i] = scanner.nextDouble();
            if (physics[i] < 0) {
                System.out.println("Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }
            
            System.out.print("Enter Chemistry marks: ");
            chemistry[i] = scanner.nextDouble();
            if (chemistry[i] < 0) {
                System.out.println("Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }
            
            System.out.print("Enter Maths marks: ");
            maths[i] = scanner.nextDouble();
            if (maths[i] < 0) {
                System.out.println("Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }
            
            percentages[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            
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
            System.out.printf("Student %d: Physics: %.1f, Chemistry: %.1f, Maths: %.1f, Percentage: %.2f%%, Grade: %s\n", 
                             (i + 1), physics[i], chemistry[i], maths[i], percentages[i], grades[i]);
        }
        
        scanner.close();
    }
}