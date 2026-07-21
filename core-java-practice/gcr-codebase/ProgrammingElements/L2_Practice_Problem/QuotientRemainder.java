import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first integer: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second integer: ");
        int num2 = sc.nextInt();
        
        int q = num1 / num2;
        int r = num1 % num2;
        
        System.out.println("Quotient: " + q);
        System.out.println("Remainder: " + r);
        
        sc.close();
    }
}
