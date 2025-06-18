import java.util.Scanner;

public class MaxHandshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();
        
        int handshakes = calculateHandshakes(numberOfStudents);
        
        System.out.println("Maximum number of handshakes possible: " + handshakes);
        
        sc.close();
    }
    
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}