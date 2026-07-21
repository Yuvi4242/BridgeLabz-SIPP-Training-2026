import java.util.Scanner;

public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        long handshakes = (long) (n * (n - 1)) / 2;
        
        System.out.println("Maximum possible handshakes: " + handshakes);
        
        sc.close();
    }
}
