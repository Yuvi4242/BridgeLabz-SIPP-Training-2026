package ArraysPractice.Lab1;

import java.util.Scanner;

public class PositiveNegativeZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemCount = readPositiveInt(scanner, "Enter number of values");
        int[] values = new int[itemCount];
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        for (int index = 0; index < values.length; index++) {
            values[index] = readInt(scanner, "Enter value " + (index + 1));
            if (values[index] > 0) {
                positiveCount++;
            } else if (values[index] < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
        System.out.println("Positive count: " + positiveCount);
        System.out.println("Negative count: " + negativeCount);
        System.out.println("Zero count: " + zeroCount);
        scanner.close();
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                int result = Integer.parseInt(input);
                if (result > 0) {
                    return result;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Please enter a positive integer.");
        }
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
