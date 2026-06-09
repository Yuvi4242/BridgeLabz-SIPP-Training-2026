import java.util.Scanner;

public class GreatestFactorFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        
        int greatest = 1;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                greatest = i;
            }
        }
        
        System.out.println("Greatest factor: " + greatest);
        
        sc.close();
    }
}
