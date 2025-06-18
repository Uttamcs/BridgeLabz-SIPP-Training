import java.util.Scanner;

public class EuclideanDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter coordinates for first point:");
        System.out.print("x1: ");
        double x1 = sc.nextDouble();
        System.out.print("y1: ");
        double y1 = sc.nextDouble();
        
        System.out.println("Enter coordinates for second point:");
        System.out.print("x2: ");
        double x2 = sc.nextDouble();
        System.out.print("y2: ");
        double y2 = sc.nextDouble();
        
        double distance = calculateDistance(x1, y1, x2, y2);
        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        
        System.out.printf("Euclidean distance between (%.2f, %.2f) and (%.2f, %.2f): %.2f\n", 
                         x1, y1, x2, y2, distance);
        
        System.out.printf("Equation of the line: y = %.2fx + %.2f\n", 
                         lineEquation[0], lineEquation[1]);
        
        sc.close();
    }
    
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        // Calculate slope (m)
        double slope = (y2 - y1) / (x2 - x1);
        
        // Calculate y-intercept (b) using y = mx + b
        double yIntercept = y1 - slope * x1;
        
        return new double[] {slope, yIntercept};
    }
}