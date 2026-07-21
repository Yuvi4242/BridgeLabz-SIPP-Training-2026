import java.util.Scanner;

public class MultiplesBelowHundredWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        
        System.out.println("Multiples of " + num + " below 100:");
        int i = num;
        while (i < 100) {
            System.out.println(i);
            i += num;
        }
        
        sc.close();
    }
}
