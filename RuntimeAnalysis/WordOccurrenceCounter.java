package RuntimeAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordOccurrenceCounter {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
    
    public static void main(String[] args) {
        String filePath = "wordcount.txt";
        String targetWord = "java";
        
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write("Java is a programming language.\n");
            writer.write("Java is widely used for enterprise applications.\n");
            writer.write("Learning Java can be fun and rewarding.\n");
            writer.write("Many frameworks are built using Java technology.\n");
            writer.close();
            
            int occurrences = countWordOccurrences(filePath, targetWord);
            System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
}