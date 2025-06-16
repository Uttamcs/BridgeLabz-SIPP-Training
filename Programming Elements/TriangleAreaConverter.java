import java.util.Scanner;
public class TriangleAreaConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base of the triangle in inches: ");
        double baseInches = sc.nextDouble();
        System.out.print("Enter the height of the triangle in inches: ");
        double heightInches = sc.nextDouble();
        double areaInches = 0.5 * baseInches * heightInches;
        double areaCm = areaInches * 6.4516; 
        double areaFeet = areaInches / 144; 
        System.out.printf("The area of the triangle is %.2f square inches, %.2f square centimeters, and %.2f square feet.%n", areaInches, areaCm, areaFeet);

    }
}