import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int[] results = new int[10];
        
        for (int i = 0; i < 10; i++) {
            results[i] = number * (i + 1);
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + results[i]);
        }
        
        scanner.close();
    }
}