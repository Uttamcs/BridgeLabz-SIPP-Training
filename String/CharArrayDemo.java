import java.util.Scanner;

public class CharArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.next();
        
        char[] customArray = stringToCharArray(input);
        char[] builtinArray = input.toCharArray();
        
        boolean areEqual = compareCharArrays(customArray, builtinArray);
        
        System.out.println("Custom char array:");
        for (char c : customArray) {
            System.out.print(c + " ");
        }
        
        System.out.println("\nBuilt-in char array:");
        for (char c : builtinArray) {
            System.out.print(c + " ");
        }
        
        System.out.println("\nBoth arrays are " + (areEqual ? "equal" : "not equal"));
        
        sc.close();
    }
    
    public static char[] stringToCharArray(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }
    
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        return true;
    }
}