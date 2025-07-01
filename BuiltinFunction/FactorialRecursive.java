import java.util.Scanner;

public class FactorialRecursive {
    public static void main(String[] args) {
        int number = getInput();
        long result = calculateFactorial(number);
        displayOutput(number, result);
    }
    
    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.close();
        return number;
    }
    
    public static long calculateFactorial(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;
        return n * calculateFactorial(n - 1);
    }
    
    public static void displayOutput(int number, long result) {
        if (result == -1) {
            System.out.println("Factorial is not defined for negative numbers");
        } else {
            System.out.println("Factorial of " + number + " is: " + result);
        }
    }
}