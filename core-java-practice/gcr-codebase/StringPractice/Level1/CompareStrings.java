package StringPractice.Level1.lab1;

import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = scanner.nextLine();
        System.out.print("Enter second string: ");
        String second = scanner.nextLine();
        boolean manualEqual = compareStringsManual(first, second);
        System.out.println("Manual comparison result: " + manualEqual);
        System.out.println("equals() comparison result: " + first.equals(second));
        scanner.close();
    }

    private static boolean compareStringsManual(String first, String second) {
        if (first == null || second == null) {
            return first == second;
        }
        if (findLength(first) != findLength(second)) {
            return false;
        }
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static int findLength(String value) {
        int count = 0;
        try {
            while (true) {
                value.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }
}
