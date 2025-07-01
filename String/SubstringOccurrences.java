import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter main string: ");
        String mainString = sc.nextLine();
        
        System.out.print("Enter substring to find: ");
        String substring = sc.nextLine();
        
        int count = countOccurrences(mainString, substring);
        
        System.out.println("\"" + substring + "\" occurs " + count + " times in \"" + mainString + "\"");
        
        sc.close();
    }
    
    public static int countOccurrences(String mainStr, String subStr) {
        int count = 0;
        int index = 0;
        
        while (index <= mainStr.length() - subStr.length()) {
            if (isSubstringAt(mainStr, subStr, index)) {
                count++;
                index += subStr.length();
            } else {
                index++;
            }
        }
        
        return count;
    }
    
    public static boolean isSubstringAt(String mainStr, String subStr, int startIndex) {
        for (int i = 0; i < subStr.length(); i++) {
            if (mainStr.charAt(startIndex + i) != subStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}