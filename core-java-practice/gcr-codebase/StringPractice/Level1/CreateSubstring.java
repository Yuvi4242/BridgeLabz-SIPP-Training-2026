package StringPractice.Level1.lab1;

import java.util.Scanner;

public class CreateSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();
        scanner.close();
        try {
            String manual = createSubstring(text, start, end);
            String builtIn = text.substring(start, end);
            System.out.println("Manual substring: " + manual);
            System.out.println("substring() result: " + builtIn);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid indexes provided.");
        }
    }

    private static String createSubstring(String text, int start, int end) {
        if (text == null || start < 0 || end > text.length() || start > end) {
            throw new StringIndexOutOfBoundsException();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            builder.append(text.charAt(i));
        }
        return builder.toString();
    }
}
