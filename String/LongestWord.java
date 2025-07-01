import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        
        String longest = findLongestWord(input);
        
        System.out.println("Longest word: " + longest);
        
        sc.close();
    }
    
    public static String findLongestWord(String sentence) {
        String[] words = splitSentence(sentence);
        String longest = words[0];
        
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }
        
        return longest;
    }
    
    public static String[] splitSentence(String sentence) {
        int wordCount = 1;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                wordCount++;
            }
        }
        
        String[] words = new String[wordCount];
        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;
        
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                words[wordIndex++] = currentWord.toString();
                currentWord = new StringBuilder();
            } else {
                currentWord.append(sentence.charAt(i));
            }
        }
        
        words[wordIndex] = currentWord.toString();
        return words;
    }
}