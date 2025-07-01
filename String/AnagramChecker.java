import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        
        boolean areAnagrams = checkAnagrams(str1, str2);
        
        System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are " + (areAnagrams ? "" : "not ") + "anagrams");
        
        sc.close();
    }
    
    public static boolean checkAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int count1 = countChar(str1, ch);
            int count2 = countChar(str2, ch);
            
            if (count1 != count2) {
                return false;
            }
        }
        
        return true;
    }
    
    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}