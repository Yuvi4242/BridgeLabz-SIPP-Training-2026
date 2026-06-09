import java.util.Scanner;

public class CalculatorUsingSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Enter operator: ");
        char op = sc.next().charAt(0);
        
        double res = 0;
        boolean valid = true;
        
        switch (op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                if (b != 0) {
                    res = a / b;
                } else {
                    System.out.println("Cannot divide by zero");
                    valid = false;
                }
                break;
            default:
                System.out.println("Invalid operator");
                valid = false;
        }
        
        if (valid) {
            System.out.println("Result: " + res);
        }
        
        sc.close();
    }
}
