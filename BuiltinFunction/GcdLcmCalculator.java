import java.util.Scanner;

public class GcdLcmCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        int gcd = calculateGCD(a, b);
        int lcm = calculateLCM(a, b, gcd);
        
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
        
        sc.close();
    }
    
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}