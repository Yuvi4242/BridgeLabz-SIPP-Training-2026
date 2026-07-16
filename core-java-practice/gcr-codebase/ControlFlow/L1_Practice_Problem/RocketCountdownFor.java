import java.util.Scanner;

public class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the starting number for countdown: ");
        int startNumber = sc.nextInt();
        System.out.println("Rocket Countdown Starting:");
        for (int i = startNumber; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("Blast Off!");
        sc.close();
    }
}
