package StringPractice.Level2.lab1;

import java.util.Arrays;
import java.util.Scanner;

public class SplitTextIntoWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        String[] manualWords = splitWords(text);
        String[] splitWords = text.trim().split("\\s+");
        System.out.println("Manual words: " + Arrays.toString(manualWords));
        System.out.println("split() words: " + Arrays.toString(splitWords));
        System.out.println("Comparison result: " + compareArrays(manualWords, splitWords));
    }

    private static String[] splitWords(String text) {
        StringBuilder word = new StringBuilder();
        String[] words = new String[text.length()];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current == ' ') {
                if (word.length() > 0) {
                    words[index++] = word.toString();
                    word = new StringBuilder();
                }
            } else {
                word.append(current);
            }
        }
        if (word.length() > 0) {
            words[index++] = word.toString();
        }
        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = words[i];
        }
        return result;
    }

    private static boolean compareArrays(String[] first, String[] second) {
        if (first.length != second.length) {
            return false;
        }
        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) {
                return false;
            }
        }
        return true;
    }
}
