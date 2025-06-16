import java.util.Scanner;

public class YoungestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the age of Amar: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter the age of Akbar: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter the age of Anthony: ");
        int anthonyAge = scanner.nextInt();

        System.out.print("Enter the height of Amar: ");
        int amarHeight = scanner.nextInt();
        System.out.print("Enter the height of Akbar: ");
        int akbarHeight = scanner.nextInt();
        System.out.print("Enter the height of Anthony: ");
        int anthonyHeight = scanner.nextInt();

        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        System.out.println("The youngest friend is: " + youngestAge + " years old.");

        int tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        System.out.println("The tallest friend is: " + tallestHeight + " cm tall.");

        scanner.close();
    }
}