import java.util.Scanner;

public class NumberChecker6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int digitCount = countDigits(number);
        int[] digits = getDigits(number, digitCount);
        int[] reversedDigits = reverseDigits(digits);
        
        System.out.println("Original digits: ");
        displayArray(digits);
        
        System.out.println("Reversed digits: ");
        displayArray(reversedDigits);
        
        boolean areEqual = compareArrays(digits, reversedDigits);
        System.out.println("Original and reversed arrays are equal: " + areEqual);
        
        System.out.println("Palindrome check: " + isPalindrome(digits));
        System.out.println("Duck number check: " + isDuckNumber(digits));
        
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
    
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        
        return reversed;
    }
    
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }
    
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static void displayArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}