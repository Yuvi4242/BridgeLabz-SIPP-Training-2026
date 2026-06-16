import java.util.Scanner;

/**
 * File: PalindromeRecursion.java
 *
 * Problem Statement:
 * Check whether a string is a palindrome using recursion.
 *
 * Approach:
 * Use recursion to compare the first and last characters. If they match, recurse on the substring
 * inside those characters. If all pairs match, the string is a palindrome.
 *
 * Time Complexity: O(n) where n is the length of the string.
 * Space Complexity: O(n) due to recursion call stack.
 *
 * Sample Input:
 * madam
 *
 * Sample Output:
 * Palindrome
 */
public class PalindromeRecursion {

    /**
     * Recursive method to verify palindrome.
     */
    public static boolean isPalindrome(String input, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        return isPalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input, 0, input.length() - 1);
        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        scanner.close();
    }
}
