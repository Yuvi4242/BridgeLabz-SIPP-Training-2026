package level2;

import java.util.Scanner;

/**
 * FactorsAnalysis - Find all factors and count of factors for a number
 */
public class FactorsAnalysis {
    
    /**
     * Finds all factors of a number
     * @param n Number to find factors for
     * @return Array of factors
     */
    public static int[] findAllFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }
    
    /**
     * Counts the number of factors
     * @param n Number to count factors for
     * @return Count of factors
     */
    public static int countFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }
    
    /**
     * Checks if number is prime
     * @param n Number to check
     * @return true if prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer!");
        } else {
            int[] factors = findAllFactors(n);
            int factorCount = countFactors(n);
            boolean prime = isPrime(n);
            
            System.out.println("\n--- Factors Analysis ---");
            System.out.println("Number: " + n);
            System.out.print("All Factors: ");
            for (int factor : factors) {
                System.out.print(factor + " ");
            }
            System.out.println();
            System.out.println("Count of Factors: " + factorCount);
            System.out.println("Is Prime: " + (prime ? "Yes" : "No"));
        }
        
        sc.close();
    }
}
