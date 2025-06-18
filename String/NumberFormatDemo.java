import java.util.Scanner;

public class NumberFormatDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String input = sc.nextLine();
        
        System.out.println("\nCalling method that generates exception:");
        generateException(input);
        
        System.out.println("\nCalling method that handles exception:");
        handleException(input);
        
        sc.close();
    }
    
    public static void generateException(String text) {
        System.out.println("Trying to parse text to integer: " + text);
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }
    
    public static void handleException(String text) {
        try {
            System.out.println("Trying to parse text to integer: " + text);
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
        System.out.println("Program continues after handling the exception");
    }
}