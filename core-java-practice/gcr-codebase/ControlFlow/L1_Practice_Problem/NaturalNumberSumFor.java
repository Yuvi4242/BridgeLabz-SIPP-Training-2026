import java.util.Scanner;

public class NaturalNumberSumFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the limit (n): ");
        int limit = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            sum += i;
        }
        System.out.println("Sum of natural numbers up to " + limit + " is: " + sum);
        sc.close();
    }
}
