import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String result = removeDuplicates(input);
        
        System.out.println("Original: " + input);
        System.out.println("After removing duplicates: " + result);
        
        sc.close();
    }
    
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean isDuplicate = false;
            
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == ch) {
                    isDuplicate = true;
                    break;
                }
            }
            
            if (!isDuplicate) {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}