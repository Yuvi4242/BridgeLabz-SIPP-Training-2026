package StringPractice.Level3.lab1;

import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String first = scanner.nextLine();
        System.out.print("Enter second text: ");
        String second = scanner.nextLine();
        scanner.close();
        boolean areAnagrams = checkAnagram(first, second);
        System.out.println("Anagram result: " + areAnagrams);
    }

    private static boolean checkAnagram(String first, String second) {
        int[] frequency = new int[256];
        String normalizedFirst = first.replaceAll("\\s+", "").toLowerCase();
        String normalizedSecond = second.replaceAll("\\s+", "").toLowerCase();
        if (normalizedFirst.length() != normalizedSecond.length()) {
            return false;
        }
        for (int i = 0; i < normalizedFirst.length(); i++) {
            frequency[normalizedFirst.charAt(i)]++;
        }
        for (int i = 0; i < normalizedSecond.length(); i++) {
            frequency[normalizedSecond.charAt(i)]--;
        }
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
