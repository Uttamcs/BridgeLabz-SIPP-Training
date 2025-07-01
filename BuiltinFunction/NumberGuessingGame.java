import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("Think of a number between 1 and 100. I'll try to guess it!");
        System.out.println("Respond with 'h' for high, 'l' for low, 'c' for correct");
        
        int low = 1, high = 100;
        int attempts = 0;
        
        while (true) {
            int guess = generateGuess(low, high, rand);
            attempts++;
            
            System.out.println("My guess is: " + guess);
            char feedback = getFeedback(sc);
            
            if (feedback == 'c') {
                System.out.println("I guessed your number in " + attempts + " attempts!");
                break;
            } else if (feedback == 'h') {
                high = guess - 1;
            } else if (feedback == 'l') {
                low = guess + 1;
            }
        }
        
        sc.close();
    }
    
    public static int generateGuess(int low, int high, Random rand) {
        return low + rand.nextInt(high - low + 1);
    }
    
    public static char getFeedback(Scanner sc) {
        System.out.print("Enter feedback (h/l/c): ");
        return sc.next().charAt(0);
    }
}