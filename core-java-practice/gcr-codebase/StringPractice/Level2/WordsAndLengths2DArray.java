package StringPractice.Level2.lab1;

import java.util.Scanner;

public class WordsAndLengths2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();
        String[][] wordsAndLengths = createWordsAndLengths(sentence);
        System.out.println("Word\tLength");
        for (int i = 0; i < wordsAndLengths.length; i++) {
            System.out.println(wordsAndLengths[i][0] + "\t" + wordsAndLengths[i][1]);
        }
    }

    private static String[][] createWordsAndLengths(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(words[i].length());
        }
        return result;
    }
}
