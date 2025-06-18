import java.util.Scanner;

public class UnitConvertor2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Unit Conversion Menu:");
        System.out.println("1. Yards to Feet");
        System.out.println("2. Feet to Yards");
        System.out.println("3. Meters to Inches");
        System.out.println("4. Inches to Meters");
        System.out.println("5. Inches to Centimeters");
        
        System.out.print("Enter your choice (1-5): ");
        int choice = sc.nextInt();
        
        System.out.print("Enter value to convert: ");
        double value = sc.nextDouble();
        double result = 0;
        
        switch (choice) {
            case 1:
                result = convertYardsToFeet(value);
                System.out.printf("%.2f yards = %.2f feet\n", value, result);
                break;
            case 2:
                result = convertFeetToYards(value);
                System.out.printf("%.2f feet = %.2f yards\n", value, result);
                break;
            case 3:
                result = convertMetersToInches(value);
                System.out.printf("%.2f meters = %.2f inches\n", value, result);
                break;
            case 4:
                result = convertInchesToMeters(value);
                System.out.printf("%.2f inches = %.2f meters\n", value, result);
                break;
            case 5:
                result = convertInchesToCentimeters(value);
                System.out.printf("%.2f inches = %.2f centimeters\n", value, result);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        sc.close();
    }
    
    public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }
    
    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }
    
    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }
    
    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }
    
    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54;
    }
}