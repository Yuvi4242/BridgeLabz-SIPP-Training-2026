package StringPractice.Level2.lab1;

import java.util.Scanner;

public class ShortestAndLongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();
        String[] words = sentence.trim().split("\\s+");
        int[] indices = findShortestAndLongestWord(words);
        System.out.println("Shortest word: " + words[indices[0]]);
        System.out.println("Longest word: " + words[indices[1]]);
    }

    private static int[] findShortestAndLongestWord(String[] words) {
        int shortest = 0;
        int longest = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < words[shortest].length()) {
                shortest = i;
            }
            if (words[i].length() > words[longest].length()) {
                longest = i;
            }
        }
        return new int[]{shortest, longest};
    }
}
