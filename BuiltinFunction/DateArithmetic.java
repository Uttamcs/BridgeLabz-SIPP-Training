import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter date (yyyy-mm-dd): ");
        String dateInput = sc.nextLine();
        
        LocalDate date = LocalDate.parse(dateInput);
        System.out.println("Original date: " + date);
        
        LocalDate modifiedDate = date.plusDays(7).plusMonths(1).plusYears(2);
        System.out.println("After adding 7 days, 1 month, 2 years: " + modifiedDate);
        
        LocalDate finalDate = modifiedDate.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + finalDate);
        
        sc.close();
    }
}