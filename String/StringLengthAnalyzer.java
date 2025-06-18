import java.util.Scanner;

public class StringLengthAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        
        String[] words = splitText(input);
        String[][] wordLengths = getWordLengths(words);
        int[] shortestLongest = findShortestAndLongest(wordLengths);
        
        System.out.println("\nShortest word: " + words[shortestLongest[0]] + " (length: " + shortestLongest[2] + ")");
        System.out.println("Longest word: " + words[shortestLongest[1]] + " (length: " + shortestLongest[3] + ")");
        
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
    
    public static int[] findShortestAndLongest(String[][] wordLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLength = Integer.parseInt(wordLengths[0][1]);
        int longestLength = Integer.parseInt(wordLengths[0][1]);
        
        for (int i = 1; i < wordLengths.length; i++) {
            int currentLength = Integer.parseInt(wordLengths[i][1]);
            
            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                shortestIndex = i;
            }
            
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestIndex = i;
            }
        }
        
        return new int[] {shortestIndex, longestIndex, shortestLength, longestLength};
    }
}