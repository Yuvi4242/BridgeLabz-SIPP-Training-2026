package StringPractice.Level3.lab1;

import java.util.Scanner;

public class CharacterFrequencyUsingUniqueCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        String[][] result = frequencyUsingUniqueCharacters(text);
        System.out.println("Character | Frequency");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " | " + result[i][1]);
        }
    }

    private static String[][] frequencyUsingUniqueCharacters(String text) {
        char[] unique = findUniqueCharacters(text);
        String[][] frequencies = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            frequencies[i][0] = String.valueOf(unique[i]);
            frequencies[i][1] = String.valueOf(countOccurrences(text, unique[i]));
        }
        return frequencies;
    }

    private static char[] findUniqueCharacters(String text) {
        String unique = "";
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (indexOf(unique, current) == -1) {
                unique += current;
            }
        }
        return unique.toCharArray();
    }

    private static int countOccurrences(String text, char target) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    private static int indexOf(String source, char target) {
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }
}
