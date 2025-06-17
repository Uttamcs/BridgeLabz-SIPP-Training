import java.util.Scanner;

public class FriendComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] ages = new int[3];
        int[] heights = new int[3];
        String[] names = {"Amar", "Akbar", "Anthony"};
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            
            System.out.print("Enter height of " + names[i] + " (in cm): ");
            heights[i] = scanner.nextInt();
        }
        
        int youngestIndex = 0;
        int tallestIndex = 0;
        
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        System.out.println("The youngest friend is " + names[youngestIndex] + " with age " + ages[youngestIndex]);
        System.out.println("The tallest friend is " + names[tallestIndex] + " with height " + heights[tallestIndex] + " cm");
        
        scanner.close();
    }
}