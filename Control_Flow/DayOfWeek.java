import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int m = scanner.nextInt();
        System.out.print("Enter day (1-31): ");
        int d = scanner.nextInt();
        System.out.print("Enter year (e.g., 2023): ");
        int y = scanner.nextInt();

        int h = (d + 13 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;

        System.out.println("Day of the week: " + h);
        scanner.close();
    }
}