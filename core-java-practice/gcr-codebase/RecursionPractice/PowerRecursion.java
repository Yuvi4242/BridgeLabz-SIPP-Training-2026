import java.util.Scanner;

/**
 * File: PowerRecursion.java
 *
 * Problem Statement:
 * Calculate x^n recursively.
 *
 * Approach:
 * Use recursion to multiply x by the power of x raised to n-1. Base case is when n is 0.
 *
 * Time Complexity: O(n) where n is the exponent.
 * Space Complexity: O(n) due to recursion call stack.
 *
 * Sample Input:
 * x = 2, n = 5
 *
 * Sample Output:
 * 32
 */
public class PowerRecursion {

    /**
     * Recursive method to compute x to the power n.
     */
    public static long power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter base x:");
        int x = scanner.nextInt();
        System.out.println("Enter exponent n:");
        int n = scanner.nextInt();

        long result = power(x, n);
        System.out.println(result);
        scanner.close();
    }
}
