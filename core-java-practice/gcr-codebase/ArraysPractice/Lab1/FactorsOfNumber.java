package ArraysPractice.Lab1;

import java.util.Arrays;
import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = readPositiveInt(scanner, "Enter a positive integer to find factors");
        int[] factors = new int[4];
        int factorCount = 0;
        for (int candidate = 1; candidate <= number; candidate++) {
            if (number % candidate == 0) {
                if (factorCount == factors.length) {
                    factors = Arrays.copyOf(factors, factors.length * 2);
                }
                factors[factorCount++] = candidate;
            }
        }
        System.out.print("Factors of " + number + ": ");
        for (int index = 0; index < factorCount; index++) {
            System.out.print(factors[index] + (index < factorCount - 1 ? ", " : ""));
        }
        System.out.println();
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
}
