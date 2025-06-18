import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        int[] counts = countVowelsAndConsonants(input);
        
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
        
        sc.close();
    }
    
    public static String checkCharType(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            ch = Character.toLowerCase(ch);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }
    
    public static int[] countVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;
        
        for (int i = 0; i < str.length(); i++) {
            String type = checkCharType(str.charAt(i));
            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        
        return new int[] {vowels, consonants};
    }
}