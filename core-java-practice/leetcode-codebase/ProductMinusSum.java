import java.util.Scanner;

public class ProductMinusSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int product = 1;
        int sum = 0;

        while (n > 0) {

            int digit = n % 10;

            product *= digit;
            sum += digit;

            n /= 10;
        }

        int result = product - sum;

        System.out.println("Difference = " + result);

        sc.close();
    }
}