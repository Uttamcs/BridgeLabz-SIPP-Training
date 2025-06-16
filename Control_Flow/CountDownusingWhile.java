
import java.util.Scanner;
public class CountDownusingWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number for countdown: ");
        int counter = scanner.nextInt();
        
        while (counter >= 1) {
            System.out.println("Countdown: " + counter);
            counter--; 
        }
        
        System.out.println("Rocket launch!");
        scanner.close();
    }
}