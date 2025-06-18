import java.util.Scanner;

public class TriangularParkRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the three sides of the triangular park (in meters):");
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        
        int rounds = calculateRounds(side1, side2, side3);
        
        System.out.println("To complete a 5 km run, the athlete must complete " + rounds + " rounds.");
        
        sc.close();
    }
    
    public static int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distance = 5000; // 5 km in meters
        return (int) Math.ceil(distance / perimeter);
    }
}