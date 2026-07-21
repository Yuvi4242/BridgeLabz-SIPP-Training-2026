package StringPractice.Level1.lab1;

import java.util.Scanner;

public class ConvertToUpperCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        String manualUpper = convertToUpperCase(text);
        System.out.println("Manual uppercase: " + manualUpper);
        System.out.println("toUpperCase() result: " + text.toUpperCase());
    }

    private static String convertToUpperCase(String text) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current >= 'a' && current <= 'z') {
                builder.append((char) (current - 32));
            } else {
                builder.append(current);
            }
        }
        return builder.toString();
    }
}
