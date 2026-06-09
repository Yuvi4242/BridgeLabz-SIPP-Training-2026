import java.util.Scanner;

public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        boolean isDivisible = number % 5 == 0;
        System.out.println("Number: " + number);
        System.out.println("Divisible by 5: " + isDivisible);
        sc.close();
    }
}