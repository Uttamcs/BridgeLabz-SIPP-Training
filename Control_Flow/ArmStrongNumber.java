import java.util.Scanner;

public class ArmStrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int sum = 0;
        int originalNumber = number;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += digit * digit * digit;
            originalNumber /= 10;
        }

        if (number == sum) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }

        scanner.close();
    }
}