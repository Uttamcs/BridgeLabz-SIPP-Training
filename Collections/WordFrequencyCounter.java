package Collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        String[] words = text.toLowerCase()
                            .replaceAll("[^a-zA-Z0-9\\s]", "")
                            .split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return frequencyMap;
    }
    
    public static void main(String[] args) {
        String filePath = "sample_text.txt";
        
        try {
            // Create a sample file
            FileWriter writer = new FileWriter(filePath);
            writer.write("Hello world, hello Java! This is a test file for word frequency counting.");
            writer.close();
            
            // Read the file
            StringBuilder content = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
            reader.close();
            
            // Count word frequency
            Map<String, Integer> wordFrequency = countWordFrequency(content.toString());
            
            System.out.println("Word Frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}