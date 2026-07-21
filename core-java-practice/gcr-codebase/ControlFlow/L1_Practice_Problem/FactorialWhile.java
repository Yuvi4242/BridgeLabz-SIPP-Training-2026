import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its factorial: ");
        int number = sc.nextInt();
        int factorial = 1;
        int counter = 1;
        while (counter <= number) {
            factorial *= counter;
            counter++;
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
        sc.close();
    }
}
