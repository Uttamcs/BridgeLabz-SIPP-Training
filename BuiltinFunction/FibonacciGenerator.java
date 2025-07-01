import java.util.Scanner;

public class FibonacciGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();
        
        generateFibonacci(terms);
        
        sc.close();
    }
    
    public static void generateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number");
            return;
        }
        
        System.out.print("Fibonacci sequence: ");
        
        int first = 0, second = 1;
        
        if (n >= 1) System.out.print(first + " ");
        if (n >= 2) System.out.print(second + " ");
        
        for (int i = 3; i <= n; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
        
        System.out.println();
    }
}