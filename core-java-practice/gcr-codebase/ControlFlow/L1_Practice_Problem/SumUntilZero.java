import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int number;
        System.out.println("Enter numbers to sum (enter 0 to stop):");
        while (true) {
            System.out.print("Enter number: ");
            number = sc.nextInt();
            if (number == 0) {
                break;
            }
            sum += number;
        }
        System.out.println("Total sum is: " + sum);
        sc.close();
    }
}
