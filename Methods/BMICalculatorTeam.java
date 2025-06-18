import java.util.Scanner;

public class BMICalculatorTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[][] personData = new double[10][3]; // [person][weight, height, BMI]
        
        for (int i = 0; i < 10; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            
            System.out.print("Enter weight (kg): ");
            personData[i][0] = sc.nextDouble();
            
            System.out.print("Enter height (cm): ");
            personData[i][1] = sc.nextDouble();
        }
        
        calculateBMI(personData);
        String[] statuses = determineBMIStatus(personData);
        
        System.out.println("\nBMI Results:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d: Height: %.1f cm, Weight: %.1f kg, BMI: %.2f, Status: %s\n", 
                             (i + 1), personData[i][1], personData[i][0], personData[i][2], statuses[i]);
        }
        
        sc.close();
    }
    
    public static void calculateBMI(double[][] personData) {
        for (int i = 0; i < personData.length; i++) {
            double heightInMeters = personData[i][1] / 100.0;
            personData[i][2] = personData[i][0] / (heightInMeters * heightInMeters);
        }
    }
    
    public static String[] determineBMIStatus(double[][] personData) {
        String[] statuses = new String[personData.length];
        
        for (int i = 0; i < personData.length; i++) {
            double bmi = personData[i][2];
            
            if (bmi < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmi < 25) {
                statuses[i] = "Normal";
            } else if (bmi < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        
        return statuses;
    }
}