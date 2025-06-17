import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] newSalaries = new double[10];
        double[] bonuses = new double[10];
        
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            
            System.out.print("Enter salary: ");
            salaries[i] = scanner.nextDouble();
            
            if (salaries[i] <= 0) {
                System.out.println("Invalid salary. Please enter again.");
                i--;
                continue;
            }
            
            System.out.print("Enter years of service: ");
            yearsOfService[i] = scanner.nextDouble();
            
            if (yearsOfService[i] < 0) {
                System.out.println("Invalid years of service. Please enter again.");
                i--;
                continue;
            }
            
            double bonusRate = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusRate;
            newSalaries[i] = salaries[i] + bonuses[i];
            
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        
        System.out.println("\nEmployee Details:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Employee %d: Old Salary: %.2f, Bonus: %.2f, New Salary: %.2f\n", 
                             (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }
        
        System.out.printf("\nTotal Bonus: %.2f\n", totalBonus);
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        
        scanner.close();
    }
}