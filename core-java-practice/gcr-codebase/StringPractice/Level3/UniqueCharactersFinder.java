package StringPractice.Level3.lab1;

import java.util.Scanner;

public class UniqueCharactersFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        char[] unique = findUniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (char ch : unique) {
            System.out.print(ch);
        }
        System.out.println();
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

    private static int indexOf(String source, char target) {
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }
}
