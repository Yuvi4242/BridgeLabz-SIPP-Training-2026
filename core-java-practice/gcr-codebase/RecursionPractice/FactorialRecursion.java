import java.util.Scanner;

/**
 * File: FactorialRecursion.java
 *
 * Problem Statement:
 * Calculate factorial of a number using recursion.
 *
 * Approach:
 * Use recursion to multiply the current number by factorial of (number - 1).
 * Base case is when the number reaches 0 or 1.
 *
 * Time Complexity: O(n) where n is the input number.
 * Space Complexity: O(n) due to recursion call stack.
 *
 * Sample Input:
 * 5
 *
 * Sample Output:
 * 120
 */
public class FactorialRecursion {

    /**
     * Recursive method to compute factorial.
     */
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to compute factorial:");
        int n = scanner.nextInt();

        long result = factorial(n);
        System.out.println(result);
        scanner.close();
    }
}
