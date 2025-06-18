import java.util.Scanner;

public class ArrayIndexDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of names: ");
        int size = sc.nextInt();
        sc.nextLine();
        
        String[] names = new String[size];
        
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i+1) + ": ");
            names[i] = sc.nextLine();
        }
        
        System.out.println("\nCalling method that generates exception:");
        generateException(names);
        
        System.out.println("\nCalling method that handles exception:");
        handleException(names);
        
        sc.close();
    }
    
    public static void generateException(String[] arr) {
        System.out.println("Trying to access element at index " + (arr.length + 2));
        String name = arr[arr.length + 2];
        System.out.println("Name: " + name);
    }
    
    public static void handleException(String[] arr) {
        try {
            System.out.println("Trying to access element at index " + (arr.length + 2));
            String name = arr[arr.length + 2];
            System.out.println("Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
        System.out.println("Program continues after handling the exception");
    }
}