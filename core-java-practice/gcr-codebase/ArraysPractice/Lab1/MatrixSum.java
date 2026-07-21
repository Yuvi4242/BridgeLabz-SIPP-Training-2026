package ArraysPractice.Lab1;

import java.util.Scanner;

public class MatrixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = readPositiveInt(scanner, "Enter number of matrix rows");
        int columns = readPositiveInt(scanner, "Enter number of matrix columns");
        int[][] matrix = new int[rows][columns];
        int totalSum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = readInt(scanner, "Enter value for row " + (row + 1) + ", column " + (col + 1));
                totalSum += matrix[row][col];
            }
        }
        System.out.println("Matrix sum is " + totalSum);
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
