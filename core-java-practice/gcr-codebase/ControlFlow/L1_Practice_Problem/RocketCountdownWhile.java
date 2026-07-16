import java.util.Scanner;

public class RocketCountdownWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the starting number for countdown: ");
        int startNumber = sc.nextInt();
        System.out.println("Rocket Countdown Starting:");
        while (startNumber >= 0) {
            System.out.println(startNumber);
            startNumber--;
        }
        System.out.println("Blast Off!");
        sc.close();
    }
}
