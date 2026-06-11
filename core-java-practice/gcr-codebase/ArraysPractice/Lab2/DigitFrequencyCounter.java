package ArraysPractice.Lab2;

import java.util.Scanner;

public class DigitFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = readInt(scanner, "Enter an integer to count digit frequency");
        int absoluteNumber = Math.abs(number);
        int[] frequencies = new int[10];
        if (absoluteNumber == 0) {
            frequencies[0] = 1;
        }
        while (absoluteNumber > 0) {
            int digit = absoluteNumber % 10;
            frequencies[digit]++;
            absoluteNumber /= 10;
        }
        for (int digit = 0; digit < frequencies.length; digit++) {
            System.out.println("Digit " + digit + ": " + frequencies[digit]);
        }
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
