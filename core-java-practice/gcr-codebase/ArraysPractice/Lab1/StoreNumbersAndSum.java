package ArraysPractice.Lab1;

import java.util.Arrays;
import java.util.Scanner;

public class StoreNumbersAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[4];
        int enteredCount = 0;
        while (true) {
            System.out.print("Enter a number or type done to finish: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int value = Integer.parseInt(input);
                if (enteredCount == numbers.length) {
                    numbers = Arrays.copyOf(numbers, numbers.length * 2);
                }
                numbers[enteredCount++] = value;
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid input. Please enter a valid integer or done.");
            }
        }
        if (enteredCount == 0) {
            System.out.println("No numbers were entered.");
        } else {
            int sum = 0;
            for (int index = 0; index < enteredCount; index++) {
                sum += numbers[index];
            }
            System.out.println("Stored numbers: " + Arrays.toString(Arrays.copyOf(numbers, enteredCount)));
            System.out.println("Sum of entered numbers is " + sum);
        }
        scanner.close();
    }
}
