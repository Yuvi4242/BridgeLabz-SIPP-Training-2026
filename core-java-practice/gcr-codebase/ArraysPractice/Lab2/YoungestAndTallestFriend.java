package ArraysPractice.Lab2;

import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int friendCount = readPositiveInt(scanner, "Enter number of friends");
        int[] ages = new int[friendCount];
        double[] heights = new double[friendCount];
        for (int index = 0; index < friendCount; index++) {
            ages[index] = readPositiveInt(scanner, "Enter age for friend " + (index + 1));
            heights[index] = readPositiveDouble(scanner, "Enter height in meters for friend " + (index + 1));
        }
        int youngestIndex = 0;
        int tallestIndex = 0;
        for (int index = 1; index < friendCount; index++) {
            if (ages[index] < ages[youngestIndex]) {
                youngestIndex = index;
            }
            if (heights[index] > heights[tallestIndex]) {
                tallestIndex = index;
            }
        }
        System.out.println("Youngest friend is friend " + (youngestIndex + 1) + " with age " + ages[youngestIndex]);
        System.out.println("Tallest friend is friend " + (tallestIndex + 1) + " with height " + heights[tallestIndex] + " meters");
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

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                double result = Double.parseDouble(input);
                if (result > 0) {
                    return result;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Please enter a positive decimal number.");
        }
    }
}
