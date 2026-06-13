package StringPractice.Level2.lab1;

import java.util.Scanner;

public class TrimStringWithoutTrim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String text = scanner.nextLine();
        scanner.close();
        int[] indexes = findTrimIndexes(text);
        String manualTrim = createSubstring(text, indexes[0], indexes[1]);
        System.out.println("Manual trim result: '" + manualTrim + "'");
        System.out.println("trim() result: '" + text.trim() + "'");
        System.out.println("Comparison result: " + compareStrings(manualTrim, text.trim()));
    }

    private static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length();
        while (start < end && text.charAt(start) == ' ') {
            start++;
        }
        while (end > start && text.charAt(end - 1) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    private static String createSubstring(String text, int start, int end) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            builder.append(text.charAt(i));
        }
        return builder.toString();
    }

    private static boolean compareStrings(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
