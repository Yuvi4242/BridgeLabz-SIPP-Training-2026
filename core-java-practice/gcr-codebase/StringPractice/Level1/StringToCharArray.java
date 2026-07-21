package StringPractice.Level1.lab1;

import java.util.Arrays;
import java.util.Scanner;

public class StringToCharArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        char[] manualArray = convertToCharArray(text);
        char[] builtInArray = text.toCharArray();
        System.out.println("Manual char array: " + Arrays.toString(manualArray));
        System.out.println("toCharArray() result: " + Arrays.toString(builtInArray));
    }

    private static char[] convertToCharArray(String text) {
        if (text == null) {
            return new char[0];
        }
        char[] array = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            array[i] = text.charAt(i);
        }
        return array;
    }
}
