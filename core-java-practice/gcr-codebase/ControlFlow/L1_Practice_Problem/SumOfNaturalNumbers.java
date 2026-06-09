import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the limit (n): ");
        int limit = sc.nextInt();
        int sum = (limit * (limit + 1)) / 2;
        System.out.println("Sum of natural numbers up to " + limit + " is: " + sum);
        sc.close();
    }
}
