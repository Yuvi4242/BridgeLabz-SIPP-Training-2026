import java.util.Scanner;

public class LeapYearMultipleIf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year: ");
        int yr = sc.nextInt();
        
        if (yr < 1582) {
            System.out.println("Invalid year");
        } else if (yr % 400 == 0) {
            System.out.println("Leap year");
        } else if (yr % 100 == 0) {
            System.out.println("Not a leap year");
        } else if (yr % 4 == 0) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
        
        sc.close();
    }
}
