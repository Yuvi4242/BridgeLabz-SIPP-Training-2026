package ArraysPractice.Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicLargestAndSecondLargestDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] digits = new int[4];
        int size = 0;
        while (true) {
            System.out.print("Enter a digit from 0 to 9 or type done: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int value = Integer.parseInt(input);
                if (value < 0 || value > 9) {
                    System.out.println("Digit must be between 0 and 9.");
                    continue;
                }
                if (size == digits.length) {
                    digits = Arrays.copyOf(digits, digits.length * 2);
                }
                digits[size++] = value;
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid input. Please enter a single digit or done.");
            }
        }
        if (size == 0) {
            System.out.println("No digits were entered.");
            scanner.close();
            return;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int index = 0; index < size; index++) {
            int current = digits[index];
            if (current > largest) {
                secondLargest = largest;
                largest = current;
            } else if (current > secondLargest && current < largest) {
                secondLargest = current;
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
}
