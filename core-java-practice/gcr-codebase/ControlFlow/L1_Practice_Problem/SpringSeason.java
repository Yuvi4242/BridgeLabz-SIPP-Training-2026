import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month number (1-12): ");
        int monthNumber = sc.nextInt();
        if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5) {
            System.out.println("Month " + monthNumber + " is in Spring season.");
        } else {
            System.out.println("Month " + monthNumber + " is not in Spring season.");
        }
        sc.close();
    }
}
