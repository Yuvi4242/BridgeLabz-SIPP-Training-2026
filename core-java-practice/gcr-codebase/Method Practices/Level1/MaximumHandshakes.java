package level1;

import java.util.Scanner;

/**
 * MaximumHandshakes - Calculate maximum handshakes between n people
 * Formula: Maximum Handshakes = n * (n - 1) / 2
 */
public class MaximumHandshakes {
    
    /**
     * Calculates maximum handshakes possible between n people
     * @param n Number of people
     * @return Maximum number of handshakes
     */
    public static int calculateMaxHandshakes(int n) {
        if (n < 2) return 0;
        return n * (n - 1) / 2;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        
        int maxHandshakes = calculateMaxHandshakes(n);
        
        System.out.println("\n--- Maximum Handshakes ---");
        System.out.println("Number of people: " + n);
        System.out.println("Maximum handshakes: " + maxHandshakes);
        
        sc.close();
    }
}
