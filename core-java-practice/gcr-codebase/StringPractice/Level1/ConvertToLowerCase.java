package StringPractice.Level1.lab1;

import java.util.Scanner;

public class ConvertToLowerCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        String manualLower = convertToLowerCase(text);
        System.out.println("Manual lowercase: " + manualLower);
        System.out.println("toLowerCase() result: " + text.toLowerCase());
    }

    private static String convertToLowerCase(String text) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current >= 'A' && current <= 'Z') {
                builder.append((char) (current + 32));
            } else {
                builder.append(current);
            }
        }
        return builder.toString();
    }
}
