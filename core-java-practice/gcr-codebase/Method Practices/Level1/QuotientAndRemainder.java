package level1;

import java.util.Scanner;

/**
 * QuotientAndRemainder - Calculate quotient and remainder of division
 */
public class QuotientAndRemainder {
    
    /**
     * Calculates quotient of two numbers
     * @param dividend Number to be divided
     * @param divisor Number dividing
     * @return Quotient
     */
    public static int calculateQuotient(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero!");
        }
        return dividend / divisor;
    }
    
    /**
     * Calculates remainder of two numbers
     * @param dividend Number to be divided
     * @param divisor Number dividing
     * @return Remainder
     */
    public static int calculateRemainder(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero!");
        }
        return dividend % divisor;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter dividend: ");
        int dividend = sc.nextInt();
        
        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();
        
        try {
            int quotient = calculateQuotient(dividend, divisor);
            int remainder = calculateRemainder(dividend, divisor);
            
            System.out.println("\n--- Quotient and Remainder ---");
            System.out.println("Dividend: " + dividend);
            System.out.println("Divisor: " + divisor);
            System.out.println("Quotient: " + quotient);
            System.out.println("Remainder: " + remainder);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        sc.close();
    }
}
