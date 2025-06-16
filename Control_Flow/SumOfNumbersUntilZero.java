import java.util.Scanner;
public class SumOfNumbersUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double userInput;

        while (true) {
            System.out.print("Enter a number (0 to stop): ");
            userInput = scanner.nextDouble();

            if (userInput == 0) {
                break; 
            }

            total += userInput; 
        }

        System.out.println("The total sum is: " + total);
    }
}