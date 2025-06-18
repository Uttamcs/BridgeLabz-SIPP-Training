public class EmployeeBonus {
    public static void main(String[] args) {
        double[][] employeeData = determineEmployeeData(10);
        
        System.out.println("Employee Data (Original):");
        System.out.println("Employee\tSalary\tYears of Service");
        System.out.println("--------------------------------");
        
        for (int i = 0; i < employeeData.length; i++) {
            System.out.printf("%d\t\t%.2f\t%.0f\n", 
                             (i + 1), employeeData[i][0], employeeData[i][1]);
        }
        
        double[][] newData = calculateBonus(employeeData);
        
        System.out.println("\nEmployee Data (With Bonus):");
        System.out.println("Employee\tOld Salary\tBonus\t\tNew Salary");
        System.out.println("------------------------------------------------");
        
        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;
        
        for (int i = 0; i < newData.length; i++) {
            System.out.printf("%d\t\t%.2f\t%.2f\t\t%.2f\n", 
                             (i + 1), employeeData[i][0], newData[i][1], newData[i][0]);
            
            totalOldSalary += employeeData[i][0];
            totalBonus += newData[i][1];
            totalNewSalary += newData[i][0];
        }
        
        System.out.println("\nSummary:");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
    }
    
    public static double[][] determineEmployeeData(int numEmployees) {
        double[][] data = new double[numEmployees][2]; // [employee][salary, years]
        
        for (int i = 0; i < numEmployees; i++) {
            // Random 5-digit salary (10000-99999)
            data[i][0] = 10000 + Math.random() * 90000;
            
            // Random years of service (0-10)
            data[i][1] = Math.random() * 10;
        }
        
        return data;
    }
    
    public static double[][] calculateBonus(double[][] employeeData) {
        double[][] newData = new double[employeeData.length][2]; // [employee][newSalary, bonus]
        
        for (int i = 0; i < employeeData.length; i++) {
            double salary = employeeData[i][0];
            double years = employeeData[i][1];
            
            double bonusRate = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusRate;
            
            newData[i][0] = salary + bonus; // New salary
            newData[i][1] = bonus; // Bonus amount
        }
        
        return newData;
    }
}