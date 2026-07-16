package ArraysPractice.Lab1;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = readNonNegativeInt(scanner, "Enter a non-negative integer");
        String value = Integer.toString(number);
        int[] digits = new int[value.length()];
        int digitSum = 0;
        for (int index = 0; index < digits.length; index++) {
            digits[index] = value.charAt(index) - '0';
            digitSum += digits[index];
        }
        System.out.println("Sum of digits is " + digitSum);
        scanner.close();
    }

    private static int readNonNegativeInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                int result = Integer.parseInt(input);
                if (result >= 0) {
                    return result;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Please enter a non-negative integer.");
        }
    }
}
