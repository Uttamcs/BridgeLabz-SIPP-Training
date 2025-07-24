package RuntimeAnalysis;

public class StringBuilderReverser {
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
        
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            reverseString("performance test for StringBuilder");
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken for 100,000 reversals: " + (endTime - startTime) / 1000000 + " ms");
    }
}