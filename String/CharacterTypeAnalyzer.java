import java.util.Scanner;

public class CharacterTypeAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String[][] charTypes = analyzeCharacters(input);
        
        System.out.println("\nCharacter Analysis:");
        System.out.println("Character\tType");
        System.out.println("--------------------");
        
        for (String[] charData : charTypes) {
            System.out.println(charData[0] + "\t\t" + charData[1]);
        }
        
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
    
    public static String[][] analyzeCharacters(String str) {
        String[][] result = new String[str.length()][2];
        
        for (int i = 0; i < str.length(); i++) {
            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = checkCharType(str.charAt(i));
        }
        
        return result;
    }
}