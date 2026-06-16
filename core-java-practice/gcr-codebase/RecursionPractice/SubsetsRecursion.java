import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * File: SubsetsRecursion.java
 *
 * Problem Statement:
 * Generate all subsets of an array recursively.
 *
 * Approach:
 * Use recursion and backtracking. At each index, either include or exclude the current element.
 * Print the subset when the recursion reaches the end of the array.
 *
 * Time Complexity: O(2^n * n) where n is the number of elements, due to subset generation and printing.
 * Space Complexity: O(n) due to recursion call stack and temporary subset storage.
 *
 * Sample Input:
 * 2
 * 1 2
 *
 * Sample Output:
 * []
 * [1]
 * [2]
 * [1, 2]
 */
public class SubsetsRecursion {

    /**
     * Recursive method to generate subsets.
     */
    public static void generateSubsets(int[] arr, int index, List<Integer> currentSubset) {
        if (index == arr.length) {
            System.out.println(currentSubset);
            return;
        }

        // Exclude current element.
        generateSubsets(arr, index + 1, currentSubset);

        // Include current element.
        currentSubset.add(arr[index]);
        generateSubsets(arr, index + 1, currentSubset);

        // Backtrack to remove the current element.
        currentSubset.remove(currentSubset.size() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements separated by spaces:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        generateSubsets(arr, 0, new ArrayList<>());
        scanner.close();
    }
}
