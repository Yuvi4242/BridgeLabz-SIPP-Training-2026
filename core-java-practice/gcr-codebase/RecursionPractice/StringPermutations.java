import java.util.Scanner;

/**
 * File: StringPermutations.java
 *
 * Problem Statement:
 * Generate all permutations of a string recursively.
 *
 * Approach:
 * Use recursion and swapping to generate permutations by fixing each character at the current position
 * and permuting the remaining characters.
 *
 * Time Complexity: O(n * n!) where n is the string length.
 * Space Complexity: O(n) due to recursion call stack, plus output storage.
 *
 * Sample Input:
 * ABC
 *
 * Sample Output:
 * ABC
 * ACB
 * BAC
 * BCA
 * CAB
 * CBA
 */
public class StringPermutations {

    /**
     * Helper method to swap characters in a character array.
     */
    public static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Recursive method to generate permutations.
     */
    public static void generatePermutations(char[] array, int index) {
        if (index == array.length - 1) {
            System.out.println(new String(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            generatePermutations(array, index + 1);
            swap(array, index, i); // backtrack
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to permute:");
        String input = scanner.nextLine().trim();

        generatePermutations(input.toCharArray(), 0);
        scanner.close();
    }
}
