import java.util.Scanner;

/**
 * File: PrintNumbersNto1.java
 *
 * Problem Statement:
 * Print numbers from N to 1 using recursion.
 *
 * Approach:
 * Use a recursive function that prints the current number and calls itself with the next lower number.
 * Stop when the number reaches zero.
 *
 * Time Complexity: O(n) where n is the input number.
 * Space Complexity: O(n) due to recursion call stack.
 *
 * Sample Input:
 * 5
 *
 * Sample Output:
 * 5 4 3 2 1
 */
public class PrintNumbersNto1 {

    /**
     * Recursive method to print numbers from current down to 1.
     */
    public static void printDescending(int n) {
        if (n <= 0) {
            return;
        }

        System.out.print(n + " ");
        printDescending(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = scanner.nextInt();

        printDescending(n);
        System.out.println();
        scanner.close();
    }
}
