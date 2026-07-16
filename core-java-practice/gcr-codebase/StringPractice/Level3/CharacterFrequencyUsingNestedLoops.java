package StringPractice.Level3.lab1;

import java.util.Scanner;

public class CharacterFrequencyUsingNestedLoops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        printFrequency(text);
    }

    private static void printFrequency(String text) {
        char[] chars = text.toCharArray();
        boolean[] processed = new boolean[chars.length];
        System.out.println("Character | Frequency");
        for (int i = 0; i < chars.length; i++) {
            if (processed[i]) {
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                    processed[j] = true;
                }
            }
            System.out.println(chars[i] + " | " + count);
        }
    }
}
