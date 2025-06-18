import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter coefficients for ax^2 + bx + c = 0:");
        System.out.print("a: ");
        double a = sc.nextDouble();
        
        System.out.print("b: ");
        double b = sc.nextDouble();
        
        System.out.print("c: ");
        double c = sc.nextDouble();
        
        double[] roots = findRoots(a, b, c);
        
        if (roots.length == 0) {
            System.out.println("No real roots exist.");
        } else if (roots.length == 1) {
            System.out.println("One root exists: " + roots[0]);
        } else {
            System.out.println("Two roots exist: " + roots[0] + " and " + roots[1]);
        }
        
        sc.close();
    }
    
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        
        if (delta < 0) {
            return new double[0];
        } else if (delta == 0) {
            return new double[] {-b / (2 * a)};
        } else {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[] {root1, root2};
        }
    }
}