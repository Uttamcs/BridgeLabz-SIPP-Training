import java.util.Scanner;

public class NumberChecker4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int digitCount = countDigits(number);
        int[] digits = getDigits(number, digitCount);
        
        int sumOfDigits = findSumOfDigits(digits);
        int sumOfSquares = findSumOfSquares(digits);
        
        System.out.println("Sum of digits: " + sumOfDigits);
        System.out.println("Sum of squares of digits: " + sumOfSquares);
        System.out.println("Harshad number check: " + isHarshadNumber(number, sumOfDigits));
        
        int[][] frequency = findDigitFrequency(digits);
        
        System.out.println("\nDigit frequency:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println("Digit " + frequency[i][0] + ": " + frequency[i][1] + " times");
            }
        }
        
        sc.close();
    }
    
    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    
    public static int[] getDigits(int number, int digitCount) {
        int[] digits = new int[digitCount];
        
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        
        return digits;
    }
    
    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
    
    public static int findSumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }
    
    public static boolean isHarshadNumber(int number, int sumOfDigits) {
        return number % sumOfDigits == 0;
    }
    
    public static int[][] findDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2]; // [digit][frequency]
        
        // Initialize the first column with digits 0-9
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }
        
        // Count frequency
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        
        return frequency;
    }
}