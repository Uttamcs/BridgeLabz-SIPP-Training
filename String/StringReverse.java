import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String reversed = reverseString(input);
        
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
        
        sc.close();
    }
    
    public static String reverseString(String str) {
        StringBuilder result = new StringBuilder();
        
        for (int i = str.length() - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }
        
        return result.toString();
    }
}