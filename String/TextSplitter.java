import java.util.Scanner;

public class TextSplitter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        
        String[] customSplit = splitText(input);
        String[] builtinSplit = input.split(" ");
        
        boolean areEqual = compareStringArrays(customSplit, builtinSplit);
        
        System.out.println("\nCustom split result:");
        for (String word : customSplit) {
            System.out.println(word);
        }
        
        System.out.println("\nBuilt-in split result:");
        for (String word : builtinSplit) {
            System.out.println(word);
        }
        
        System.out.println("\nBoth results are " + (areEqual ? "same" : "different"));
        
        sc.close();
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
    
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        
        return true;
    }
}