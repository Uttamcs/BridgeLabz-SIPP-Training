import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        System.out.print("Enter character to remove: ");
        char charToRemove = sc.next().charAt(0);
        
        String result = removeCharacter(input, charToRemove);
        
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result);
        
        sc.close();
    }
    
    public static String removeCharacter(String str, char ch) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                result.append(str.charAt(i));
            }
        }
        
        return result.toString();
    }
}