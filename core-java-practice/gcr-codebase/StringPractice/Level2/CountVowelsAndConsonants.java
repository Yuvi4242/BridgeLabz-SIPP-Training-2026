package StringPractice.Level2.lab1;

import java.util.Scanner;

public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        int[] result = countVowelsAndConsonants(text);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }

    private static String checkCharacterType(char ch) {
        char lower = Character.toLowerCase(ch);
        if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
            return "vowel";
        }
        if (lower >= 'a' && lower <= 'z') {
            return "consonant";
        }
        return "other";
    }

    private static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacterType(text.charAt(i));
            if (type.equals("vowel")) {
                vowels++;
            } else if (type.equals("consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }
}
