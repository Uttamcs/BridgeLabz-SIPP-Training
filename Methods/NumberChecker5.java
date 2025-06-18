import java.util.Scanner;

public class NumberChecker5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        System.out.println("Prime number check: " + isPrimeNumber(number));
        System.out.println("Neon number check: " + isNeonNumber(number));
        System.out.println("Spy number check: " + isSpyNumber(number));
        System.out.println("Automorphic number check: " + isAutomorphicNumber(number));
        System.out.println("Buzz number check: " + isBuzzNumber(number));
        
        sc.close();
    }
    
    public static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;
        
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        
        return sum == number;
    }
    
    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        
        return sum == product;
    }
    
    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        int temp = number;
        
        // Count digits in number
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        
        // Get last 'count' digits of square
        int lastDigits = square % (int)Math.pow(10, count);
        
        return lastDigits == number;
    }
    
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
}