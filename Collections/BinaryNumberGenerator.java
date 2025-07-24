package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerator {
    public static String[] generateBinaryNumbers(int n) {
        if (n <= 0) {
            return new String[0];
        }
        
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        
        for (int i = 0; i < n; i++) {
            result[i] = queue.remove();
            queue.add(result[i] + "0");
            queue.add(result[i] + "1");
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int n = 5;
        String[] binaryNumbers = generateBinaryNumbers(n);
        
        System.out.println("First " + n + " binary numbers:");
        for (String binary : binaryNumbers) {
            System.out.print(binary + " ");
        }
    }
}