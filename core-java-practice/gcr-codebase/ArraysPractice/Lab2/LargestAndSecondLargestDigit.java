package ArraysPractice.Lab2;

import java.util.Scanner;

public class LargestAndSecondLargestDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = readNonNegativeInt(scanner, "Enter a non-negative integer");
        String digitsString = Integer.toString(number);
        int[] digits = new int[digitsString.length()];
        for (int index = 0; index < digits.length; index++) {
            digits[index] = digitsString.charAt(index) - '0';
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int index = 0; index < digits.length; index++) {
            int value = digits[index];
            if (value > largest) {
                secondLargest = largest;
                largest = value;
            } else if (value > secondLargest && value < largest) {
                secondLargest = value;
            }
        }
        System.out.println("Largest digit: " + largest);
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest digit not available");
        } else {
            System.out.println("Second largest digit: " + secondLargest);
        }
        scanner.close();
    }

    private static int readNonNegativeInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= 0) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Please enter a non-negative integer.");
        }
    }
}
