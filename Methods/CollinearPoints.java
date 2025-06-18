import java.util.Scanner;

public class CollinearPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter coordinates for three points:");
        
        System.out.print("x1: ");
        double x1 = sc.nextDouble();
        System.out.print("y1: ");
        double y1 = sc.nextDouble();
        
        System.out.print("x2: ");
        double x2 = sc.nextDouble();
        System.out.print("y2: ");
        double y2 = sc.nextDouble();
        
        System.out.print("x3: ");
        double x3 = sc.nextDouble();
        System.out.print("y3: ");
        double y3 = sc.nextDouble();
        
        boolean collinearBySlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean collinearByArea = areCollinearByArea(x1, y1, x2, y2, x3, y3);
        
        System.out.println("Points are collinear (by slope method): " + collinearBySlope);
        System.out.println("Points are collinear (by area method): " + collinearByArea);
        
        sc.close();
    }
    
    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calculate slopes
        double slope1 = (y2 - y1) / (x2 - x1);
        double slope2 = (y3 - y2) / (x3 - x2);
        
        // Points are collinear if slopes are equal (with some tolerance for floating-point comparison)
        return Math.abs(slope1 - slope2) < 0.0001;
    }
    
    public static boolean areCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calculate area of triangle using the formula:
        // Area = 0.5 * |x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)|
        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        
        // Points are collinear if area is zero (with some tolerance for floating-point comparison)
        return area < 0.0001;
    }
}