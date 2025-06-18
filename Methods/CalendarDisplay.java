import java.util.Scanner;

public class CalendarDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        
        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Month should be between 1 and 12.");
            return;
        }
        
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);
        
        System.out.println("\n    " + monthName + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        
        // Print leading spaces
        for (int i = 0; i < firstDay; i++) {
            System.out.print("   ");
        }
        
        // Print days
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            
            if ((day + firstDay) % 7 == 0 || day == daysInMonth) {
                System.out.println();
            }
        }
        
        sc.close();
    }
    
    public static String getMonthName(int month) {
        String[] months = {"", "January", "February", "March", "April", "May", "June", 
                          "July", "August", "September", "October", "November", "December"};
        return months[month];
    }
    
    public static int getDaysInMonth(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        
        return days[month];
    }
    
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static int getFirstDayOfMonth(int month, int year) {
        // Zeller's Congruence algorithm
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        
        int k = year % 100;
        int j = year / 100;
        
        int dayOfWeek = (1 + 13 * (month + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        
        // Convert from Zeller's result (0 = Saturday) to our format (0 = Sunday)
        return (dayOfWeek + 6) % 7;
    }
}