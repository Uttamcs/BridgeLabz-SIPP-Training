package RuntimeAnalysis;

public class StringBufferConcatenator {
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!", " ", "This", " ", "is", " ", "a", " ", "test"};
        String result = concatenateStrings(words);
        System.out.println("Concatenated result: " + result);
        
        long startTime = System.nanoTime();
        String[] testArray = new String[1000];
        for (int i = 0; i < 1000; i++) {
            testArray[i] = "word" + i;
        }
        concatenateStrings(testArray);
        long endTime = System.nanoTime();
        System.out.println("Time taken to concatenate 1000 strings: " + (endTime - startTime) / 1000000 + " ms");
    }
}