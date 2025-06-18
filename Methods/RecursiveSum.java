import java.util.Scanner;

public class RecursiveSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        
        int recursiveSum = sumRecursive(n);
        int formulaSum = sumFormula(n);
        
        System.out.println("Sum of first " + n + " natural numbers (recursive): " + recursiveSum);
        System.out.println("Sum of first " + n + " natural numbers (formula): " + formulaSum);
        System.out.println("Both results are " + (recursiveSum == formulaSum ? "equal" : "not equal"));
        
        sc.close();
    }
    
    public static int sumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumRecursive(n - 1);
    }
    
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
}