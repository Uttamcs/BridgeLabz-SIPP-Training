import java.util.Scanner;

public class StudentVoteChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] ages = new int[10];
        
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            
            if (canStudentVote(ages[i])) {
                System.out.println("Student with age " + ages[i] + " can vote.");
            } else {
                System.out.println("Student with age " + ages[i] + " cannot vote.");
            }
        }
        
        sc.close();
    }
    
    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }
}