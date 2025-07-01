import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        
        System.out.println("Choose operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter choice (1-4): ");
        
        int choice = sc.nextInt();
        double result = 0;
        
        switch (choice) {
            case 1:
                result = add(num1, num2);
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = subtract(num1, num2);
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = multiply(num1, num2);
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                result = divide(num1, num2);
                if (result != Double.NEGATIVE_INFINITY) {
                    System.out.println(num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        sc.close();
    }
    
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return Double.NEGATIVE_INFINITY;
        }
        return a / b;
    }
}