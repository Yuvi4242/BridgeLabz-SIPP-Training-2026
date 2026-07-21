import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        
        int cnt = 0;
        int n = num;
        
        if (n == 0) {
            cnt = 1;
        } else {
            if (n < 0) {
                n = -n;
            }
            while (n > 0) {
                cnt++;
                n /= 10;
            }
        }
        
        System.out.println("Number of digits: " + cnt);
        
        sc.close();
    }
}
