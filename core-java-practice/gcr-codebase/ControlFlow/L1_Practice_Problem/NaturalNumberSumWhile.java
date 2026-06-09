import java.util.Scanner;

public class NaturalNumberSumWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the limit (n): ");
        int limit = sc.nextInt();
        int counter = 1;
        int sum = 0;
        while (counter <= limit) {
            sum += counter;
            counter++;
        }
        System.out.println("Sum of natural numbers up to " + limit + " is: " + sum);
        sc.close();
    }
}
