package level3;

import java.util.Scanner;

/**
 * MatrixOperations - Basic matrix operations (addition, subtraction, transpose)
 */
public class MatrixOperations {
    
    /**
     * Reads a matrix from user input
     * @param rows Number of rows
     * @param cols Number of columns
     * @return 2D matrix
     */
    public static int[][] readMatrix(int rows, int cols) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[rows][cols];
        
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
    
    /**
     * Displays a matrix
     * @param matrix Matrix to display
     */
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Adds two matrices
     * @param a First matrix
     * @param b Second matrix
     * @return Sum of matrices
     */
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    
    /**
     * Subtracts two matrices
     * @param a First matrix
     * @param b Second matrix
     * @return Difference of matrices
     */
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
    
    /**
     * Transposes a matrix
     * @param matrix Matrix to transpose
     * @return Transposed matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        
        System.out.println("\n--- First Matrix ---");
        int[][] matrix1 = readMatrix(rows, cols);
        
        System.out.println("\n--- Second Matrix ---");
        int[][] matrix2 = readMatrix(rows, cols);
        
        int[][] sum = addMatrices(matrix1, matrix2);
        int[][] diff = subtractMatrices(matrix1, matrix2);
        int[][] transpose = transposeMatrix(matrix1);
        
        System.out.println("\n--- Matrix 1 ---");
        displayMatrix(matrix1);
        
        System.out.println("\n--- Matrix 2 ---");
        displayMatrix(matrix2);
        
        System.out.println("\n--- Sum (Matrix1 + Matrix2) ---");
        displayMatrix(sum);
        
        System.out.println("\n--- Difference (Matrix1 - Matrix2) ---");
        displayMatrix(diff);
        
        System.out.println("\n--- Transpose of Matrix1 ---");
        displayMatrix(transpose);
    }
}
