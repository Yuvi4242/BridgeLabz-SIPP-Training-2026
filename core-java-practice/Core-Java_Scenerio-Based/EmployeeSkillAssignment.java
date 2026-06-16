import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * File: EmployeeSkillAssignment.java
 *
 * Problem Statement:
 * Given an array of employee skill scores and a target value, recursively print all possible
 * team combinations whose total skill score equals the target.
 *
 * Approach:
 * Use recursion and backtracking to explore each combination by including or excluding each skill score.
 * When the current sum equals the target, print the current combination.
 *
 * Time Complexity: O(2^n) in the worst case, where n is the number of employees.
 * Space Complexity: O(n) due to recursion call stack and temporary combination storage.
 *
 * Sample Input:
 * 4
 * 2 3 5 7
 * 10
 *
 * Sample Output:
 * [3, 7]
 * [2, 3, 5]
 */
public class EmployeeSkillAssignment {

    /**
     * Recursive helper to find combinations of skill scores that sum to the target.
     */
    public static void findCombinations(int[] skills, int target, int index, List<Integer> currentCombination, int currentSum) {
        // If the current sum matches the target, print the current combination.
        if (currentSum == target) {
            System.out.println(currentCombination);
            return;
        }

        // If index is out of range or current sum exceeds target, stop exploring this path.
        if (index >= skills.length || currentSum > target) {
            return;
        }

        // Include the current skill score.
        currentCombination.add(skills[index]);
        findCombinations(skills, target, index + 1, currentCombination, currentSum + skills[index]);

        // Backtrack by removing the last included skill score.
        currentCombination.remove(currentCombination.size() - 1);

        // Exclude the current skill score and move to the next.
        findCombinations(skills, target, index + 1, currentCombination, currentSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of employees:");
        int n = scanner.nextInt();

        int[] skills = new int[n];
        System.out.println("Enter the skill scores separated by spaces:");
        for (int i = 0; i < n; i++) {
            skills[i] = scanner.nextInt();
        }

        System.out.println("Enter the target skill sum:");
        int target = scanner.nextInt();

        System.out.println("Possible team combinations with total skill " + target + ":");
        findCombinations(skills, target, 0, new ArrayList<>(), 0);
        scanner.close();
    }
}
