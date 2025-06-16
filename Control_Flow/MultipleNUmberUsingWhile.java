import java.util.Scanner;
public class MultipleNUmberUsingWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();
        
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
        } else {
            int counter = number - 1; // Initialize counter
            
            System.out.println("Multiples of " + number + " below 100:");
            while (counter > 1) { // Loop until counter is greater than 1
                if (counter % number == 0) { // Check if counter is a multiple of number
                    System.out.println(counter); // Print the multiple
                }
                counter--; // Decrement the counter
            }
        }
        
        scanner.close(); // Close the scanner
    }
}