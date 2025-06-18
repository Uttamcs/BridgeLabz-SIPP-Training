import java.util.Scanner;

public class NumberChecker3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int digitCount = countDigits(number);
        int[] digits = getDigits(number, digitCount);
        
        System.out.println("Duck number check: " + isDuckNumber(digits));
        System.out.println("Armstrong number check: " + isArmstrongNumber(digits, digitCount));
        
        int[] largestElements = findLargestElements(digits);
        System.out.println("Largest digit: " + largestElements[0]);
        System.out.println("Second largest digit: " + largestElements[1]);
        
        int[] smallestElements = findSmallestElements(digits);
        System.out.println("Smallest digit: " + smallestElements[0]);
        System.out.println("Second smallest digit: " + smallestElements[1]);
        
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
    
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isArmstrongNumber(int[] digits, int digitCount) {
        int sum = 0;
        int originalNumber = 0;
        
        for (int digit : digits) {
            originalNumber = originalNumber * 10 + digit;
            sum += Math.pow(digit, digitCount);
        }
        
        return sum == originalNumber;
    }
    
    public static int[] findLargestElements(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        
        return new int[] {largest, secondLargest};
    }
    
    public static int[] findSmallestElements(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        
        return new int[] {smallest, secondSmallest};
    }
}