import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        
        int orig = num;
        int sumDigits = 0;
        
        while (num > 0) {
            sumDigits += num % 10;
            num /= 10;
        }
        
        if (orig % sumDigits == 0) {
            System.out.println("Harshad number");
        } else {
            System.out.println("Not a Harshad number");
        }
        
        sc.close();
    }
}
