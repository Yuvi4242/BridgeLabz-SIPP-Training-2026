package level2;

import java.util.Scanner;

/**
 * RecursiveNaturalNumberSum - Calculate sum of natural numbers using recursion
 */
public class RecursiveNaturalNumberSum {
    
    /**
     * Calculates sum of first n natural numbers recursively
     * @param n Number to calculate sum until
     * @return Sum of first n natural numbers
     */
    public static long recursiveSum(int n) {
        if (n == 0) return 0;
        return n + recursiveSum(n - 1);
    }
    
    /**
     * Calculates sum using formula
     * @param n Number to calculate sum until
     * @return Sum of first n natural numbers
     */
    public static long formulaSum(int n) {
        return (long) n * (n + 1) / 2;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive integer n: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer!");
        } else {
            long recursiveResult = recursiveSum(n);
            long formulaResult = formulaSum(n);
            
            System.out.println("\n--- Recursive Sum ---");
            System.out.println("n = " + n);
            System.out.println("Sum (Recursive): " + recursiveResult);
            System.out.println("Sum (Formula): " + formulaResult);
        }
        
        sc.close();
    }
}
