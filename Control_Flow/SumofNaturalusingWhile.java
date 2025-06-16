import java.util.Scanner;
public class SumofNaturalusingWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        
        if (n < 1) {
            System.out.println("Please enter a valid natural number greater than 0.");
            return;
        }
      
        int formulaSum = n * (n + 1) / 2;
        
        int loopSum = 0;
        int i = 1;
        while (i <= n) {
            loopSum += i;
            i++;
        }
        
        if (formulaSum == loopSum) {
            System.out.println("Both computations are correct.");
            System.out.println("Sum of first " + n + " natural numbers using formula: " + formulaSum);
            System.out.println("Sum of first " + n + " natural numbers using while loop: " + loopSum);
        } else {
            System.out.println("There is an error in the computations.");
        }
    }
}