import java.util.Scanner;

public class FirstNumberSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int firstNumber = sc.nextInt();
        System.out.print("Enter second number: ");
        int secondNumber = sc.nextInt();
        if (firstNumber < secondNumber) {
            System.out.println("First number is smallest: " + firstNumber);
        } else {
            System.out.println("Second number is smallest: " + secondNumber);
        }
        sc.close();
    }
}
