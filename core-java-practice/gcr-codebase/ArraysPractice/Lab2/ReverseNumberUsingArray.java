package ArraysPractice.Lab2;

import java.util.Scanner;

public class ReverseNumberUsingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = readInt(scanner, "Enter an integer to reverse");
        int absoluteNumber = Math.abs(number);
        String digitsString = Integer.toString(absoluteNumber);
        int[] digits = new int[digitsString.length()];
        for (int index = 0; index < digits.length; index++) {
            digits[index] = digitsString.charAt(index) - '0';
        }
        int reversedNumber = 0;
        for (int index = digits.length - 1; index >= 0; index--) {
            reversedNumber = reversedNumber * 10 + digits[index];
        }
        if (number < 0) {
            reversedNumber = -reversedNumber;
        }
        System.out.println("Reversed number is " + reversedNumber);
        scanner.close();
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Please enter an integer.");
        }
    }
}
