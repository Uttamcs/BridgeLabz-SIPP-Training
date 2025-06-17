import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] heights = new double[11];
        double sum = 0;
        
        System.out.println("Enter the heights of 11 football players (in cm):");
        for (int i = 0; i < 11; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }
        
        double mean = sum / 11;
        System.out.printf("Mean height of the football team: %.2f cm", mean);
        
        scanner.close();
    }
}