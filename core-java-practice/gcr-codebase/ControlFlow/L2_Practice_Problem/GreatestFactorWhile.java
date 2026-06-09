import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        
        int greatest = 1;
        int i = 1;
        while (i < num) {
            if (num % i == 0) {
                greatest = i;
            }
            i++;
        }
        
        System.out.println("Greatest factor: " + greatest);
        
        sc.close();
    }
}
