package ArraysPractice.Lab1;

import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemCount = readPositiveInt(scanner, "Enter number of values");
        int[] numbers = new int[itemCount];
        int evenCount = 0;
        int oddCount = 0;
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = readInt(scanner, "Enter value " + (index + 1));
            if (numbers[index] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        int[] evenNumbers = new int[evenCount];
        int[] oddNumbers = new int[oddCount];
        int evenIndex = 0;
        int oddIndex = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] % 2 == 0) {
                evenNumbers[evenIndex++] = numbers[index];
            } else {
                oddNumbers[oddIndex++] = numbers[index];
            }
        }
        System.out.print("Even numbers: ");
        for (int index = 0; index < evenNumbers.length; index++) {
            System.out.print(evenNumbers[index] + (index < evenNumbers.length - 1 ? ", " : "\n"));
        }
        System.out.print("Odd numbers: ");
        for (int index = 0; index < oddNumbers.length; index++) {
            System.out.print(oddNumbers[index] + (index < oddNumbers.length - 1 ? ", " : "\n"));
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
