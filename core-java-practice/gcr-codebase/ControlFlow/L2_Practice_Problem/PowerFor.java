import java.util.Scanner;

public class PowerFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.print("Enter power: ");
        int pow = sc.nextInt();
        
        int res = 1;
        for (int i = 0; i < pow; i++) {
            res *= num;
        }
        
        System.out.println("Result: " + res);
        
        sc.close();
    }
}
