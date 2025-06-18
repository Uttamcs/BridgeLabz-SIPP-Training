import java.util.Scanner;

public class UnitConvertor3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Unit Conversion Menu:");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        
        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();
        
        System.out.print("Enter value to convert: ");
        double value = sc.nextDouble();
        double result = 0;
        
        switch (choice) {
            case 1:
                result = convertKmToMiles(value);
                System.out.printf("%.2f km = %.2f miles\n", value, result);
                break;
            case 2:
                result = convertMilesToKm(value);
                System.out.printf("%.2f miles = %.2f km\n", value, result);
                break;
            case 3:
                result = convertMetersToFeet(value);
                System.out.printf("%.2f meters = %.2f feet\n", value, result);
                break;
            case 4:
                result = convertFeetToMeters(value);
                System.out.printf("%.2f feet = %.2f meters\n", value, result);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        sc.close();
    }
    
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }
    
    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }
    
    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }
    
    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }
}