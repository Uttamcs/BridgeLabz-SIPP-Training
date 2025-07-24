package RuntimeAnalysis;

import java.io.*;

public class ByteToCharConverter {
    public static void convertByteToChar(String filePath, String charset) {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, charset);
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            System.out.println("File content with " + charset + " encoding:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filePath = "encoding_test.txt";
        
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            String content = "This is a test for InputStreamReader with different encodings: äöüß";
            fos.write(content.getBytes("UTF-8"));
            fos.close();
            
            long startTime = System.nanoTime();
            convertByteToChar(filePath, "UTF-8");
            long endTime = System.nanoTime();
            System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}