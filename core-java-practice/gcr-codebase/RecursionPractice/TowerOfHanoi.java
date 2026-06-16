import java.util.Scanner;

/**
 * File: TowerOfHanoi.java
 *
 * Problem Statement:
 * Print all moves required to solve the Tower of Hanoi puzzle recursively.
 *
 * Approach:
 * Move n-1 disks from source to auxiliary, move the nth disk from source to target,
 * then move n-1 disks from auxiliary to target.
 *
 * Time Complexity: O(2^n) where n is the number of disks.
 * Space Complexity: O(n) due to recursion call stack.
 *
 * Sample Input:
 * 3
 *
 * Sample Output:
 * Move disk 1 from A to C
 * Move disk 2 from A to B
 * Move disk 1 from C to B
 * Move disk 3 from A to C
 * Move disk 1 from B to A
 * Move disk 2 from B to C
 * Move disk 1 from A to C
 */
public class TowerOfHanoi {

    /**
     * Recursive method to print Tower of Hanoi moves.
     */
    public static void solveHanoi(int n, char source, char auxiliary, char target) {
        if (n == 0) {
            return;
        }

        solveHanoi(n - 1, source, target, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        solveHanoi(n - 1, auxiliary, source, target);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of disks:");
        int n = scanner.nextInt();

        solveHanoi(n, 'A', 'B', 'C');
        scanner.close();
    }
}
