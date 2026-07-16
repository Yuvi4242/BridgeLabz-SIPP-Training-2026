package StringPractice.Level3.lab1;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        System.out.println("Two pointer result: " + isPalindromeTwoPointer(normalized));
        System.out.println("Recursion result: " + isPalindromeRecursion(normalized, 0, normalized.length() - 1));
        System.out.println("Reverse array result: " + isPalindromeReverseArray(normalized));
    }

    private static boolean isPalindromeTwoPointer(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindromeRecursion(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecursion(text, left + 1, right - 1);
    }

    private static boolean isPalindromeReverseArray(String text) {
        char[] characters = text.toCharArray();
        int left = 0;
        int right = characters.length - 1;
        while (left < right) {
            if (characters[left] != characters[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
