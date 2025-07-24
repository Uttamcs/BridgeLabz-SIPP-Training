package RuntimeAnalysis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ComprehensiveComparison {
    public static void compareStringBuilders(int iterations) {
        System.out.println("Comparing StringBuilder vs StringBuffer for " + iterations + " iterations:");
        
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start) / 1000000 + " ms");
        
        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start) / 1000000 + " ms");
    }
    
    public static void compareReaders(String filePath) {
        System.out.println("\nComparing FileReader vs InputStreamReader:");
        
        try {
            // Create a test file
            try (FileWriter writer = new FileWriter(filePath)) {
                for (int i = 0; i < 10000; i++) {
                    writer.write("Line " + i + " of test data\n");
                }
            }
            
            // Test FileReader
            long start = System.nanoTime();
            int wordCount = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    wordCount += line.split("\\s+").length;
                }
            }
            long end = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (end - start) / 1000000 + " ms");
            
            // Test InputStreamReader
            start = System.nanoTime();
            wordCount = 0;
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filePath)))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    wordCount += line.split("\\s+").length;
                }
            }
            end = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time: " + (end - start) / 1000000 + " ms");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        compareStringBuilders(1000000);
        compareReaders("comprehensive_test.txt");
    }
}