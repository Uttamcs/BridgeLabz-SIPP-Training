import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the dividend: ");
        int dividend = sc.nextInt();
        
        System.out.print("Enter the divisor: ");
        int divisor = sc.nextInt();
        
        int[] result = findRemainderAndQuotient(dividend, divisor);
        
        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);
        
    }
    
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        
        return new int[] {quotient, remainder};
    }
}