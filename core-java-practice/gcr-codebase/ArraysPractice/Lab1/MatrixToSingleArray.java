package ArraysPractice.Lab1;

import java.util.Scanner;

public class MatrixToSingleArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = readPositiveInt(scanner, "Enter number of rows");
        int columns = readPositiveInt(scanner, "Enter number of columns");
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = readInt(scanner, "Enter value for row " + (row + 1) + ", column " + (column + 1));
            }
        }
        int[] flatArray = new int[rows * columns];
        int position = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                flatArray[position++] = matrix[row][column];
            }
        }
        System.out.print("Single dimensional array: ");
        for (int index = 0; index < flatArray.length; index++) {
            System.out.print(flatArray[index] + (index < flatArray.length - 1 ? ", " : ""));
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
