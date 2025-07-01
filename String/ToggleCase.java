import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String toggled = toggleCase(input);
        
        System.out.println("Original: " + input);
        System.out.println("Toggled: " + toggled);
        
        sc.close();
    }
    
    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}