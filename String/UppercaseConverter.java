import java.util.Scanner;

public class UppercaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        
        String customUppercase = convertToUppercase(input);
        String builtinUppercase = input.toUpperCase();
        
        boolean areEqual = compareStrings(customUppercase, builtinUppercase);
        
        System.out.println("Custom uppercase: " + customUppercase);
        System.out.println("Built-in uppercase: " + builtinUppercase);
        System.out.println("Both results are " + (areEqual ? "same" : "different"));
        
        sc.close();
    }
    
    public static String convertToUppercase(String str) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
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