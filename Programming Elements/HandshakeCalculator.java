import java.util.Scanner;
public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();
        if (numberOfStudents < 2) {
            System.out.println("At least two students are required for handshakes.");
        } else {
            int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
            System.out.println("The maximum number of possible handshakes among " + numberOfStudents + " students is: " + handshakes);
        }
    }
}