package RuntimeAnalysis;

import java.util.HashSet;

public class DuplicateCharRemover {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("Original: " + input);
        System.out.println("Without duplicates: " + result);
        
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            removeDuplicates("abcdefghijklmnopqrstuvwxyz");
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken for 100,000 operations: " + (endTime - startTime) / 1000000 + " ms");
    }
}