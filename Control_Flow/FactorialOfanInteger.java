import java.util.Scanner;
public class FactorialOfanInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        if (number < 0) {
            System.out.println("Please enter a valid positive integer.");
            return;
        }
        if (number == 0) {
            System.out.println("The factorial of 0 is 1.");
            return;
        }       
        long factorial = 1;
        int i = 1;
        
        while (i <= number) {
            factorial *= i;
            i++;
        }       
        System.out.println("The factorial of " + number + " is " + factorial);
    }
}