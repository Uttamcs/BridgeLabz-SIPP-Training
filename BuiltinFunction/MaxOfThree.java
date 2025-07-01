import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        int[] numbers = getInput();
        int maximum = findMaximum(numbers[0], numbers[1], numbers[2]);
        
        System.out.println("Maximum of " + numbers[0] + ", " + numbers[1] + ", " + numbers[2] + " is: " + maximum);
    }
    
    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[3];
        
        System.out.print("Enter first number: ");
        numbers[0] = sc.nextInt();
        
        System.out.print("Enter second number: ");
        numbers[1] = sc.nextInt();
        
        System.out.print("Enter third number: ");
        numbers[2] = sc.nextInt();
        
        sc.close();
        return numbers;
    }
    
    public static int findMaximum(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}