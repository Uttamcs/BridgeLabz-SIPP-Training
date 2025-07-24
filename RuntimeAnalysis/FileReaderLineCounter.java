package RuntimeAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderLineCounter {
    public static void readFileLines(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
            }
            System.out.println("Total lines: " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filePath = "sample.txt";
        
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write("Line 1: This is a test file.\n");
            writer.write("Line 2: Created for FileReader example.\n");
            writer.write("Line 3: Testing line by line reading.\n");
            writer.close();
            
            System.out.println("Reading file line by line:");
            readFileLines(filePath);
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
}