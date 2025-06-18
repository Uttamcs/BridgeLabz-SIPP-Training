import java.util.Scanner;

public class StringLengthFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.next();
        
        int customLength = findLength(input);
        int builtinLength = input.length();
        
        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtinLength);
        System.out.println("Both results are " + (customLength == builtinLength ? "same" : "different"));
        
        sc.close();
    }
    
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
}