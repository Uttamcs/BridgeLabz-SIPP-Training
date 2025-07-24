package RuntimeAnalysis;

import java.io.*;

public class ConsoleInputWriter {
    public static void readAndWriteInput(String outputFile) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(isr);
             FileWriter writer = new FileWriter(outputFile)) {
            
            System.out.println("Enter text (type 'exit' to stop):");
            String line;
            while (true) {
                line = reader.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line + "\n");
            }
            System.out.println("Input saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // For demonstration, we'll simulate user input instead of waiting for actual console input
        String outputFile = "user_input.txt";
        
        // This would normally be used with actual user input
        // readAndWriteInput(outputFile);
        
        // For demonstration, we'll just show the method structure
        System.out.println("ConsoleInputWriter is ready to use.");
        System.out.println("In a real scenario, it would read user input and write to: " + outputFile);
    }
}