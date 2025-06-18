import java.util.Scanner;

public class TrigonometricFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        
        double[] results = calculateTrigonometricFunctions(angle);
        
        System.out.printf("Sin(%.2f°) = %.4f\n", angle, results[0]);
        System.out.printf("Cos(%.2f°) = %.4f\n", angle, results[1]);
        System.out.printf("Tan(%.2f°) = %.4f\n", angle, results[2]);
        
        sc.close();
    }
    
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double[] results = new double[3];
        
        results[0] = Math.sin(radians);
        results[1] = Math.cos(radians);
        results[2] = Math.tan(radians);
        
        return results;
    }
}