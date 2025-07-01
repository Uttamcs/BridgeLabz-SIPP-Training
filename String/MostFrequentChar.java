import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        char mostFrequent = findMostFrequentChar(input);
        
        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
        
        sc.close();
    }
    
    public static char findMostFrequentChar(String str) {
        char mostFrequent = str.charAt(0);
        int maxCount = 1;
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            int count = 0;
            
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == currentChar) {
                    count++;
                }
            }
            
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = currentChar;
            }
        }
        
        return mostFrequent;
    }
}