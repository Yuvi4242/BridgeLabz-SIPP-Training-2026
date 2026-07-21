import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter salary: ");
        int sal = sc.nextInt();
        System.out.print("Enter years: ");
        int yrs = sc.nextInt();
        
        if (yrs > 5) {
            int bonus = (sal * 5) / 100;
            System.out.println("Bonus: " + bonus);
        } else {
            System.out.println("No bonus");
        }
        
        sc.close();
    }
}
