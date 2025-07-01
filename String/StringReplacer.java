import java.util.Scanner;

public class StringReplacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        
        System.out.print("Enter word to replace: ");
        String oldWord = sc.next();
        
        System.out.print("Enter replacement word: ");
        String newWord = sc.next();
        
        String result = replaceWord(sentence, oldWord, newWord);
        
        System.out.println("Original: " + sentence);
        System.out.println("Modified: " + result);
        
        sc.close();
    }
    
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        StringBuilder result = new StringBuilder();
        String[] words = splitSentence(sentence);
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result.append(newWord);
            } else {
                result.append(words[i]);
            }
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
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