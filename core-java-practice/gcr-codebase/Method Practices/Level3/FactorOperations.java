package level3;

import java.util.Scanner;

/**
 * FactorOperations - Advanced factor analysis
 */
public class FactorOperations {
    
    /**
     * Finds greatest common divisor using Euclidean algorithm
     * @param a First number
     * @param b Second number
     * @return GCD of two numbers
     */
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    /**
     * Finds least common multiple
     * @param a First number
     * @param b Second number
     * @return LCM of two numbers
     */
    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs((a / gcd(a, b)) * b);
    }
    
    /**
     * Finds all common factors of two numbers
     * @param a First number
     * @param b Second number
     * @return Array of common factors
     */
    public static long[] commonFactors(long a, long b) {
        long g = gcd(a, b);
        int count = 0;
        for (long i = 1; i <= g; i++) {
            if (g % i == 0) count++;
        }
        long[] factors = new long[count];
        int index = 0;
        for (long i = 1; i <= g; i++) {
            if (g % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        long a = sc.nextLong();
        
        System.out.print("Enter second number: ");
        long b = sc.nextLong();
        
        long gcdValue = gcd(a, b);
        long lcmValue = lcm(a, b);
        long[] common = commonFactors(a, b);
        
        System.out.println("\n--- Factor Operations ---");
        System.out.println("First number: " + a);
        System.out.println("Second number: " + b);
        System.out.println("GCD: " + gcdValue);
        System.out.println("LCM: " + lcmValue);
        System.out.print("Common Factors: ");
        for (long factor : common) {
            System.out.print(factor + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
