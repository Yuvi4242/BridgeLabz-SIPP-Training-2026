import java.util.Scanner;

/**
 * File: SumOfNaturalNumbers.java
 *
 * Problem Statement:
 * Find the sum of the first N natural numbers using recursion.
 *
 * Approach:
 * Use recursion to add the current number to the sum of numbers before it.
 * Base case is when n reaches 1.
 *
 * Time Complexity: O(n) where n is the input number.
 * Space Complexity: O(n) due to recursion call stack.
 *
 * Sample Input:
 * 5
 *
 * Sample Output:
 * 15
 */
public class SumOfNaturalNumbers {

    /**
     * Recursive method to compute sum of natural numbers.
     */
    public static int sumNatural(int n) {
        if (n <= 1) {
            return n;
        }

        return n + sumNatural(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value for N:");
        int n = scanner.nextInt();

        int sum = sumNatural(n);
        System.out.println(sum);
        scanner.close();
    }
}
