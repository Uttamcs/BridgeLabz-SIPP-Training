import java.util.Scanner;

public class StudentVoteChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        
        int[] ages = generateRandomAges(numStudents);
        String[][] voteStatus = checkVoteEligibility(ages);
        
        System.out.println("\nStudent Voting Eligibility:");
        System.out.println("Student\tAge\tCan Vote");
        System.out.println("------------------------");
        
        for (int i = 0; i < voteStatus.length; i++) {
            System.out.println((i+1) + "\t" + voteStatus[i][0] + "\t" + voteStatus[i][1]);
        }
        
        sc.close();
    }
    
    public static int[] generateRandomAges(int count) {
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            ages[i] = 10 + (int)(Math.random() * 20); // Ages between 10 and 29
        }
        return ages;
    }
    
    public static String[][] checkVoteEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            
            if (ages[i] < 0) {
                result[i][1] = "No";
            } else if (ages[i] >= 18) {
                result[i][1] = "Yes";
            } else {
                result[i][1] = "No";
            }
        }
        
        return result;
    }
}