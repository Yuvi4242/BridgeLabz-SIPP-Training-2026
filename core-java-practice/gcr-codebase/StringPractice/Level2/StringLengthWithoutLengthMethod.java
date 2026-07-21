package StringPractice.Level2.lab1;

import java.util.Scanner;

public class StringLengthWithoutLengthMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        int manualLength = findLength(text);
        System.out.println("Manual length: " + manualLength);
        System.out.println("length() output: " + text.length());
    }

    private static int findLength(String text) {
        int length = 0;
        while (true) {
            try {
                text.charAt(length);
                length++;
            } catch (IndexOutOfBoundsException exception) {
                break;
            }
        }
        return length;
    }
}
