import java.util.Scanner;
public class MultiplicationTable6to9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer to find its multiplication table from 6 to 9: ");
        int number = scanner.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.println("Multiplication table of " + number + " from 6 to 9:");
            for (int i = 6; i <= 9; i++) {
                System.out.println(number + " * " + i + " = " + (number * i));
            }
        }
        
        scanner.close();
    }
}