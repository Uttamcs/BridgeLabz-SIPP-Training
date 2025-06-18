import java.util.Scanner;

public class StringTrimmer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();
        
        int[] indices = trimSpaces(input);
        String customTrimmed = createSubstring(input, indices[0], indices[1] + 1);
        String builtinTrimmed = input.trim();
        
        boolean areEqual = compareStrings(customTrimmed, builtinTrimmed);
        
        System.out.println("Original string: '" + input + "'");
        System.out.println("Custom trimmed: '" + customTrimmed + "'");
        System.out.println("Built-in trimmed: '" + builtinTrimmed + "'");
        System.out.println("Both results are " + (areEqual ? "same" : "different"));
        
        sc.close();
    }
    
    public static int[] trimSpaces(String str) {
        int start = 0;
        int end = str.length() - 1;
        
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        
        return new int[] {start, end};
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