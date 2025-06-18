import java.util.Scanner;

public class UnitConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Unit Conversion Menu:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Pounds to Kilograms");
        System.out.println("4. Kilograms to Pounds");
        System.out.println("5. Gallons to Liters");
        System.out.println("6. Liters to Gallons");
        
        System.out.print("Enter your choice (1-6): ");
        int choice = sc.nextInt();
        
        System.out.print("Enter value to convert: ");
        double value = sc.nextDouble();
        double result = 0;
        
        switch (choice) {
            case 1:
                result = convertFahrenheitToCelsius(value);
                System.out.printf("%.2f°F = %.2f°C\n", value, result);
                break;
            case 2:
                result = convertCelsiusToFahrenheit(value);
                System.out.printf("%.2f°C = %.2f°F\n", value, result);
                break;
            case 3:
                result = convertPoundsToKilograms(value);
                System.out.printf("%.2f lb = %.2f kg\n", value, result);
                break;
            case 4:
                result = convertKilogramsToPounds(value);
                System.out.printf("%.2f kg = %.2f lb\n", value, result);
                break;
            case 5:
                result = convertGallonsToLiters(value);
                System.out.printf("%.2f gal = %.2f L\n", value, result);
                break;
            case 6:
                result = convertLitersToGallons(value);
                System.out.printf("%.2f L = %.2f gal\n", value, result);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        sc.close();
    }
    
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }
    
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }
    
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }
    
    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }
}