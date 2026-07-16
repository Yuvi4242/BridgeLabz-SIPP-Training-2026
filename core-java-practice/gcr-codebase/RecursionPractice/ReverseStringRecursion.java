import java.util.Scanner;

/**
 * File: ReverseStringRecursion.java
 *
 * Problem Statement:
 * Reverse a string using recursion.
 *
 * Approach:
 * Use recursion to process the substring starting at the next index and append the current character
 * after the reversed substring.
 *
 * Time Complexity: O(n^2) in this implementation due to repeated string concatenation.
 * Space Complexity: O(n^2) because of recursive calls and string building.
 *
 * Sample Input:
 * hello
 *
 * Sample Output:
 * olleh
 */
public class ReverseStringRecursion {

    /**
     * Recursive method to reverse a string.
     */
    public static String reverseString(String input, int index) {
        if (index >= input.length()) {
            return "";
        }

        // Recur for the rest of the string and append the current character at the end.
        return reverseString(input, index + 1) + input.charAt(index);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to reverse:");
        String input = scanner.nextLine();

        String reversed = reverseString(input, 0);
        System.out.println(reversed);
        scanner.close();
    }
}
