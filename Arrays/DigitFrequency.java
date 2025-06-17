import java.util.Scanner;

public class DigitFrequency {
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
        
        // Calculate frequency
        int[] frequency = new int[10]; // 0-9 digits
        
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        
        System.out.println("Digit frequencies in " + number + ":");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " times");
            }
        }
        
        scanner.close();
    }
}