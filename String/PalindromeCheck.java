import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        boolean isPalindrome = checkPalindrome(input);
        
        System.out.println("\"" + input + "\" is " + (isPalindrome ? "" : "not ") + "a palindrome");
        
        sc.close();
    }
    
    public static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}