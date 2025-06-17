import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int temp = Math.abs(number);
        int digitCount = 0;
        
        // Count digits
        int countTemp = temp;
        while (countTemp > 0) {
            digitCount++;
            countTemp /= 10;
        }
        
        int[] digits = new int[digitCount];
        int index = 0;
        
        // Extract digits
        while (temp > 0) {
            digits[index++] = temp % 10;
            temp /= 10;
        }
        
        System.out.print("Reversed number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i]);
        }
        
        scanner.close();
    }
}