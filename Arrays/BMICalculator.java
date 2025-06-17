import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numPersons = scanner.nextInt();
        
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];
        
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            
            System.out.print("Enter weight (kg): ");
            weights[i] = scanner.nextDouble();
            
            System.out.print("Enter height (cm): ");
            heights[i] = scanner.nextDouble();
            
            double heightInMeters = heights[i] / 100.0;
            bmis[i] = weights[i] / (heightInMeters * heightInMeters);
            
            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 25) {
                statuses[i] = "Normal";
            } else if (bmis[i] < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        
        System.out.println("\nBMI Results:");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("Person %d: Height: %.1f cm, Weight: %.1f kg, BMI: %.2f, Status: %s\n", 
                             (i + 1), heights[i], weights[i], bmis[i], statuses[i]);
        }
        
        scanner.close();
    }
}