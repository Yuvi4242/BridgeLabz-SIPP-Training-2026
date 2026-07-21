import java.util.Scanner;

/**
 * File: FibonacciRecursion.java
 *
 * Problem Statement:
 * Return the nth Fibonacci number recursively.
 *
 * Approach:
 * Use recursion to calculate Fibonacci numbers. The base cases are n == 0 and n == 1.
 * For other values, compute Fibonacci(n-1) + Fibonacci(n-2).
 *
 * Time Complexity: O(2^n) due to repeated recursion.
 * Space Complexity: O(n) because of recursion call stack.
 *
 * Sample Input:
 * 6
 *
 * Sample Output:
 * 8
 */
public class FibonacciRecursion {

    /**
     * Recursive method to compute nth Fibonacci number.
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = scanner.nextInt();

        int result = fibonacci(n);
        System.out.println(result);
        scanner.close();
    }
}
