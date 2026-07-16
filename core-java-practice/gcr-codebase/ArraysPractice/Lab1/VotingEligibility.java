package ArraysPractice.Lab1;

import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personCount = readPositiveInt(scanner, "Enter number of people");
        int[] ages = new int[personCount];
        for (int index = 0; index < ages.length; index++) {
            ages[index] = readNonNegativeInt(scanner, "Enter age for person " + (index + 1));
        }
        for (int index = 0; index < ages.length; index++) {
            String eligibility = ages[index] >= 18 ? "Eligible to vote" : "Not eligible to vote";
            System.out.println("Person " + (index + 1) + ": " + eligibility);
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
