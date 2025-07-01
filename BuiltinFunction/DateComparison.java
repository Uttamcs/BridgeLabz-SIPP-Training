import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first date (yyyy-mm-dd): ");
        String date1Input = sc.nextLine();
        
        System.out.print("Enter second date (yyyy-mm-dd): ");
        String date2Input = sc.nextLine();
        
        LocalDate date1 = LocalDate.parse(date1Input);
        LocalDate date2 = LocalDate.parse(date2Input);
        
        System.out.println("First date: " + date1);
        System.out.println("Second date: " + date2);
        
        if (date1.isBefore(date2)) {
            System.out.println("First date is before second date");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is after second date");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the same");
        }
        
        sc.close();
    }
}