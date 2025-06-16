import java.util.Scanner;

public class AthleteRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of side1 (in meters): ");
        double s1 = sc.nextDouble();

        System.out.print("Enter length of side2 (in meters): ");
        double s2 = sc.nextDouble();

        System.out.print("Enter length of side3 (in meters): ");
        double s3 = sc.nextDouble();

        double p = s1 + s2 + s3;

        double td = 5000; 
        double r = td / p;

        System.out.println("The total number of rounds the athlete will run is " + r + " to complete 5 km");
    }
}
