package ArraysPractice.Lab1;

import java.util.Scanner;

public class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = readInt(scanner, "Enter the start number");
        int end = readInt(scanner, "Enter the end number");
        while (end < start) {
            System.out.println("End number must be greater than or equal to start number.");
            end = readInt(scanner, "Enter the end number");
        }
        String[] fizzBuzz = new String[end - start + 1];
        for (int value = start; value <= end; value++) {
            int index = value - start;
            fizzBuzz[index] = computeFizzBuzz(value);
        }
        for (int index = 0; index < fizzBuzz.length; index++) {
            System.out.println((start + index) + ": " + fizzBuzz[index]);
        }
        scanner.close();
    }

    private static String computeFizzBuzz(int value) {
        boolean divisibleBy3 = value % 3 == 0;
        boolean divisibleBy5 = value % 5 == 0;
        if (divisibleBy3 && divisibleBy5) {
            return "FizzBuzz";
        }
        if (divisibleBy3) {
            return "Fizz";
        }
        if (divisibleBy5) {
            return "Buzz";
        }
        return Integer.toString(value);
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
