package StringPractice.Level3.lab1;

import java.util.Scanner;

public class CharacterFrequencyASCII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        String[][] frequencyTable = characterFrequency(text);
        System.out.println("Character | Frequency");
        for (int i = 0; i < frequencyTable.length; i++) {
            System.out.println(frequencyTable[i][0] + " | " + frequencyTable[i][1]);
        }
    }

    private static String[][] characterFrequency(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        int count = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                count++;
            }
        }
        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(frequency[i]);
                index++;
            }
        }
        return result;
    }
}
