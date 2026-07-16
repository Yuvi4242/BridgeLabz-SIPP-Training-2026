package level1;

import java.util.Scanner;

/**
 * SumOfNNaturalNumbers - Calculate sum of first n natural numbers
 * Formula: Sum = n * (n + 1) / 2
 */
public class SumOfNNaturalNumbers {
    
    /**
     * Calculates sum using formula
     * @param n Number of natural numbers
     * @return Sum of first n natural numbers
     */
    public static long sumUsingFormula(int n) {
        return (long) n * (n + 1) / 2;
    }
    
    /**
     * Calculates sum using loop
     * @param n Number of natural numbers
     * @return Sum of first n natural numbers
     */
    public static long sumUsingLoop(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive integer n: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer!");
        } else {
            long sumFormula = sumUsingFormula(n);
            long sumLoop = sumUsingLoop(n);
            
            System.out.println("\n--- Sum of First n Natural Numbers ---");
            System.out.println("n = " + n);
            System.out.println("Sum (using formula): " + sumFormula);
            System.out.println("Sum (using loop): " + sumLoop);
        }
        
        sc.close();
    }
}
