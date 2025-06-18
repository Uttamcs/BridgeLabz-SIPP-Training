import java.util.Scanner;

public class WordLengthAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        
        String[] words = splitText(input);
        String[][] wordLengths = getWordLengths(words);
        
        System.out.println("\nWord Analysis:");
        System.out.println("Word\tLength");
        System.out.println("----------------");
        
        for (String[] wordData : wordLengths) {
            System.out.println(wordData[0] + "\t" + Integer.parseInt(wordData[1]));
        }
        
        sc.close();
    }
    
    public static String[] splitText(String text) {
        int wordCount = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        
        String[] words = new String[wordCount];
        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;
        
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex++] = currentWord.toString();
                currentWord = new StringBuilder();
            } else {
                currentWord.append(text.charAt(i));
            }
        }
        
        words[wordIndex] = currentWord.toString();
        return words;
    }
    
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        
        return result;
    }
}