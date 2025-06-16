import java.util.Scanner;
public class CountDownNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number for countdown: ");
        int counter = scanner.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println("Countdown: " + i);
        }
        
        System.out.println("Rocket launch!");
        scanner.close();
    }
}