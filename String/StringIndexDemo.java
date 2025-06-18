import java.util.Scanner;

public class StringIndexDemo {
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
        System.out.println("Trying to access character at index " + (str.length() + 5));
        char ch = str.charAt(str.length() + 5);
        System.out.println("Character: " + ch);
    }
    
    public static void handleException(String str) {
        try {
            System.out.println("Trying to access character at index " + (str.length() + 5));
            char ch = str.charAt(str.length() + 5);
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
        System.out.println("Program continues after handling the exception");
    }
}