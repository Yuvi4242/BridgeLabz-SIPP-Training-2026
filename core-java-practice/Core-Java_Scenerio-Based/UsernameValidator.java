import java.util.Scanner;

/**
 * File: UsernameValidator.java
 *
 * Problem Statement:
 * Recursively verify whether a username contains only lowercase letters.
 *
 * Approach:
 * Use recursion to check each character of the username. If every character is a lowercase letter,
 * the username is valid. The recursion advances one character at a time.
 *
 * Time Complexity: O(n) where n is the length of the username.
 * Space Complexity: O(n) due to recursion call stack.
 *
 * Sample Input:
 * abcdxyz
 *
 * Sample Output:
 * true
 */
public class UsernameValidator {

    /**
     * Recursive helper to verify lowercase letters only.
     */
    public static boolean isLowercaseUsername(String username, int index) {
        // Base case: if index reaches the end, all characters are valid.
        if (index >= username.length()) {
            return true;
        }

        char ch = username.charAt(index);

        // Check if the current character is a lowercase letter.
        if (ch >= 'a' && ch <= 'z') {
            return isLowercaseUsername(username, index + 1);
        }

        // If any character is not lowercase, return false.
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username:");
        String username = scanner.nextLine().trim();

        boolean result = isLowercaseUsername(username, 0);
        System.out.println(result);
        scanner.close();
    }
}
