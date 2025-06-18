import java.util.Scanner;

public class LowercaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        
        String customLowercase = convertToLowercase(input);
        String builtinLowercase = input.toLowerCase();
        
        boolean areEqual = compareStrings(customLowercase, builtinLowercase);
        
        System.out.println("Custom lowercase: " + customLowercase);
        System.out.println("Built-in lowercase: " + builtinLowercase);
        System.out.println("Both results are " + (areEqual ? "same" : "different"));
        
        sc.close();
    }
    
    public static String convertToLowercase(String str) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}