import java.util.Scanner;

/**
 * File: ConsecutiveSensorReadings.java
 *
 * Problem Statement:
 * Given an integer array of sensor readings, recursively check whether the readings are strictly increasing.
 *
 * Approach:
 * Use recursion to compare each reading with the next one. If every adjacent pair is strictly increasing,
 * the function returns true. The recursion moves from the first index to the second last index.
 *
 * Time Complexity: O(n) where n is the number of readings.
 * Space Complexity: O(n) due to recursion call stack.
 *
 * Sample Input:
 * 5
 * 12 15 18 22 30
 *
 * Sample Output:
 * true
 */
public class ConsecutiveSensorReadings {

    /**
     * Recursive helper to check strictly increasing readings.
     */
    public static boolean isStrictlyIncreasing(int[] readings, int index) {
        // Base case: if we reached the last element, no more pairs to compare.
        if (index >= readings.length - 1) {
            return true;
        }

        // Check current element with the next element.
        if (readings[index] < readings[index + 1]) {
            // Recur for the next pair.
            return isStrictlyIncreasing(readings, index + 1);
        } else {
            // If any pair is not strictly increasing, return false.
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of sensor readings:");
        int n = scanner.nextInt();

        int[] readings = new int[n];
        System.out.println("Enter the sensor readings separated by spaces:");
        for (int i = 0; i < n; i++) {
            readings[i] = scanner.nextInt();
        }

        boolean result = isStrictlyIncreasing(readings, 0);
        System.out.println(result);
        scanner.close();
    }
}
