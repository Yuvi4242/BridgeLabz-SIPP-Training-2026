import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Division by zero detected");
        } catch (InputMismatchException e) {
            System.out.println("Please enter integers only");
        } finally {
            System.out.println("Operation completed");
            sc.close();
        }
    }
}
