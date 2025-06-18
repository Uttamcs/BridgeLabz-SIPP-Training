import java.util.Scanner;

public class SubstringDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.next();
        
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        
        String substring1 = createSubstring(input, start, end);
        String substring2 = input.substring(start, end);
        
        boolean areEqual = compareStrings(substring1, substring2);
        
        System.out.println("Substring using charAt(): " + substring1);
        System.out.println("Substring using substring(): " + substring2);
        System.out.println("Both results are " + (areEqual ? "same" : "different"));
        
        sc.close();
    }
    
    public static String createSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
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