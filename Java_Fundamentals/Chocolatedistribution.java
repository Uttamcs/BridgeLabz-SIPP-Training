import java.util.Scanner;

public class Chocolatedistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int chocolate = sc.nextInt();

	    System.out.print("Enter the number of children: ");
	    int childrens = sc.nextInt();

        int chocolatesPerChild = chocolate / childrens;
        int remainingChocolates = chocolate % childrens;

        System.out.println("The weight of the person in pounds is " + chocolatesPerChild + 
                           " and in kg is " + remainingChocolates);

    }
}
