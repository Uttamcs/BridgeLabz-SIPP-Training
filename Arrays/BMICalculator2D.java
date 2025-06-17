import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numPersons = scanner.nextInt();
        
        double[][] personData = new double[numPersons][3]; // [person][weight, height, BMI]
        String[] weightStatus = new String[numPersons];
        
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            
            System.out.print("Enter weight (kg): ");
            personData[i][0] = scanner.nextDouble();
            if (personData[i][0] <= 0) {
                System.out.println("Weight must be positive. Please enter again.");
                i--;
                continue;
            }
            
            System.out.print("Enter height (cm): ");
            personData[i][1] = scanner.nextDouble();
            if (personData[i][1] <= 0) {
                System.out.println("Height must be positive. Please enter again.");
                i--;
                continue;
            }
            
            double heightInMeters = personData[i][1] / 100.0;
            personData[i][2] = personData[i][0] / (heightInMeters * heightInMeters);
            
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        System.out.println("\nBMI Results:");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("Person %d: Height: %.1f cm, Weight: %.1f kg, BMI: %.2f, Status: %s\n", 
                             (i + 1), personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
        
        scanner.close();
    }
}