import java.util.Scanner;

public class PowerWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.print("Enter power: ");
        int pow = sc.nextInt();
        
        int res = 1;
        int i = 0;
        while (i < pow) {
            res *= num;
            i++;
        }
        
        System.out.println("Result: " + res);
        
        sc.close();
    }
}
