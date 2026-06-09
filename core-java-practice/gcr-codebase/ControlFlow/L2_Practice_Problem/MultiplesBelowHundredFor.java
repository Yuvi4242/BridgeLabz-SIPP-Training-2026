import java.util.Scanner;

public class MultiplesBelowHundredFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        
        System.out.println("Multiples of " + num + " below 100:");
        for (int i = num; i < 100; i += num) {
            System.out.println(i);
        }
        
        sc.close();
    }
}
