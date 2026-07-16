package ArraysPractice.Lab1;

import java.util.Scanner;

public class MultiplicationTableSixToNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startTable = 6;
        int endTable = 9;
        int tableSize = 10;
        int[][] tables = new int[endTable - startTable + 1][tableSize];
        for (int table = startTable; table <= endTable; table++) {
            int rowIndex = table - startTable;
            for (int multiplier = 1; multiplier <= tableSize; multiplier++) {
                tables[rowIndex][multiplier - 1] = table * multiplier;
            }
        }
        for (int table = startTable; table <= endTable; table++) {
            int rowIndex = table - startTable;
            System.out.println("Multiplication table for " + table + ":");
            for (int multiplier = 1; multiplier <= tableSize; multiplier++) {
                System.out.println(table + " x " + multiplier + " = " + tables[rowIndex][multiplier - 1]);
            }
        }
        scanner.close();
    }
}
