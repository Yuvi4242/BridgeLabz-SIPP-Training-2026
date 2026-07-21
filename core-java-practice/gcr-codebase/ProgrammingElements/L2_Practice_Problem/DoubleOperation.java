import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();
        
        double res1 = a + b * c;
        double res2 = a * b + c;
        double res3 = c + a / b;
        double res4 = a % b + c;
        
        System.out.println("a + b * c = " + res1);
        System.out.println("a * b + c = " + res2);
        System.out.println("c + a / b = " + res3);
        System.out.println("a % b + c = " + res4);
        
        sc.close();
    }
}
