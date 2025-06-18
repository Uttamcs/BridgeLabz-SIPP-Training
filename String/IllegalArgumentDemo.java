import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        System.out.println("\nCalling method that generates exception:");
        generateException(input);
        
        System.out.println("\nCalling method that handles exception:");
        handleException(input);
        
        sc.close();
    }
    
    public static void generateException(String str) {
        System.out.println("Trying to get substring with start index > end index");
        String result = str.substring(5, 2);
        System.out.println("Result: " + result);
    }
    
    public static void handleException(String str) {
        try {
            System.out.println("Trying to get substring with start index > end index");
            String result = str.substring(5, 2);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
        System.out.println("Program continues after handling the exception");
    }
}