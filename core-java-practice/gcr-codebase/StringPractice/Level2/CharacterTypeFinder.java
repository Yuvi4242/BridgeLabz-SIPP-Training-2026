package StringPractice.Level2.lab1;

import java.util.Scanner;

public class CharacterTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        String[][] result = createCharacterTypeTable(text);
        System.out.println("Character | Type");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " | " + result[i][1]);
        }
    }

    private static String getCharacterType(char ch) {
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            char lower = Character.toLowerCase(ch);
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }

    private static String[][] createCharacterTypeTable(String text) {
        String[][] table = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            table[i][0] = String.valueOf(text.charAt(i));
            table[i][1] = getCharacterType(text.charAt(i));
        }
        return table;
    }
}
