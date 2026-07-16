package ArraysPractice.Lab1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int baseNumber = readInt(scanner, "Enter the base number");
        int length = readPositiveInt(scanner, "Enter the table length");
        int[] table = new int[length];
        for (int index = 0; index < table.length; index++) {
            table[index] = baseNumber * (index + 1);
        }
        for (int index = 0; index < table.length; index++) {
            System.out.println(baseNumber + " x " + (index + 1) + " = " + table[index]);
        }
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
