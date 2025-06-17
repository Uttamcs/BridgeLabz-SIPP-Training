import java.util.Scanner;

public class DigitAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        int temp = Math.abs(number);
        
        while (temp > 0) {
            if (index == maxDigit) {
                maxDigit *= 2;
                int[] tempArray = new int[maxDigit];
                System.arraycopy(digits, 0, tempArray, 0, index);
                digits = tempArray;
            }
            digits[index++] = temp % 10;
            temp /= 10;
        }
        
        int largest = 0, secondLargest = 0;
        
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        
        scanner.close();
    }
}