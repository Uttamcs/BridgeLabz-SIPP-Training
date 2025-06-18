public class NullPointerDemo {
    public static void main(String[] args) {
        System.out.println("Calling method that generates exception:");
        generateException();
        
        System.out.println("\nCalling method that handles exception:");
        handleException();
    }
    
    public static void generateException() {
        String text = null;
        System.out.println("Trying to call length() on null string");
        int length = text.length();
        System.out.println("Length: " + length);
    }
    
    public static void handleException() {
        try {
            String text = null;
            System.out.println("Trying to call length() on null string");
            int length = text.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
        System.out.println("Program continues after handling the exception");
    }
}