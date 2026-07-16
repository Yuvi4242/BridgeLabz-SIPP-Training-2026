package ArraysPractice.Lab1;

import java.util.Scanner;

public class MeanHeightFootballTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerCount = readPositiveInt(scanner, "Enter number of football players");
        double[] heights = new double[playerCount];
        double totalHeight = 0;
        for (int index = 0; index < heights.length; index++) {
            heights[index] = readPositiveDouble(scanner, "Enter height in meters for player " + (index + 1));
            totalHeight += heights[index];
        }
        double meanHeight = totalHeight / heights.length;
        System.out.printf("Mean height of football team is %.2f meters%n", meanHeight);
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
