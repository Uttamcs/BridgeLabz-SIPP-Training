import java.util.Scanner;
public class CountNoofDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        int count = 0;
        if (number < 0) {
            number = -number;
        }
        do {
            count++;
            number /= 10;
        } while (number != 0);
        
        System.out.println("Number of digits: " + count);
        
        scanner.close();
    }
}