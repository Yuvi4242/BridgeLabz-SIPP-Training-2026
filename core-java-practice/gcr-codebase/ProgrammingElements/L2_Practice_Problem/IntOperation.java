import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.print("Enter c: ");
        int c = sc.nextInt();
        
        int res1 = a + b * c;
        int res2 = a * b + c;
        int res3 = c + a / b;
        int res4 = a % b + c;
        
        System.out.println("a + b * c = " + res1);
        System.out.println("a * b + c = " + res2);
        System.out.println("c + a / b = " + res3);
        System.out.println("a % b + c = " + res4);
        
        sc.close();
    }
}
