public class PalindromeChecker {
    String text;
    
    public PalindromeChecker(String text) {
        this.text = text;
    }
    
    public boolean checkPalindrome() {
        String cleanText = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0, right = cleanText.length() - 1;
        
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public void displayResult() {
        boolean isPalindrome = checkPalindrome();
        System.out.println("Text: \"" + text + "\"");
        System.out.println("Is Palindrome: " + (isPalindrome ? "Yes" : "No"));
    }
    
    public static void main(String[] args) {
        PalindromeChecker checker1 = new PalindromeChecker("racecar");
        PalindromeChecker checker2 = new PalindromeChecker("hello");
        
        checker1.displayResult();
        System.out.println();
        checker2.displayResult();
    }
}