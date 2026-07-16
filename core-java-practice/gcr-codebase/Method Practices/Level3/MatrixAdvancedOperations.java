package level3;

import java.util.Scanner;

/**
 * MatrixAdvancedOperations - Advanced matrix operations (multiplication, determinant, inverse)
 */
public class MatrixAdvancedOperations {
    
    /**
     * Reads a matrix from user input
     * @param rows Number of rows
     * @param cols Number of columns
     * @return 2D matrix
     */
    public static double[][] readMatrix(int rows, int cols) {
        Scanner sc = new Scanner(System.in);
        double[][] matrix = new double[rows][cols];
        
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }
    
    /**
     * Displays a matrix
     * @param matrix Matrix to display
     */
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(String.format("%8.2f ", val));
            }
            System.out.println();
        }
    }
    
    /**
     * Multiplies two matrices
     * @param a First matrix (m x n)
     * @param b Second matrix (n x p)
     * @return Product matrix (m x p)
     */
    public static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int m = a.length;
        int n = a[0].length;
        int p = b[0].length;
        
        double[][] result = new double[m][p];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    
    /**
     * Calculates determinant of a 2x2 or 3x3 matrix
     * @param matrix Square matrix
     * @return Determinant value
     */
    public static double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;
        
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        
        if (n == 3) {
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                 - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                 + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        }
        
        return 0;
    }
    
    /**
     * Calculates inverse of a 2x2 matrix
     * @param matrix 2x2 matrix
     * @return Inverse matrix
     */
    public static double[][] inverseMatrix2x2(double[][] matrix) {
        double det = calculateDeterminant(matrix);
        
        if (Math.abs(det) < 1e-9) {
            System.out.println("Matrix is singular (determinant = 0), inverse does not exist.");
            return null;
        }
        
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;
        
        return inverse;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Matrix Advanced Operations ---");
        System.out.println("1. Matrix Multiplication");
        System.out.println("2. Matrix Determinant");
        System.out.println("3. Matrix Inverse (2x2)");
        System.out.print("Choose operation: ");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print("Enter rows for Matrix A: ");
                int m = sc.nextInt();
                System.out.print("Enter common dimension: ");
                int n = sc.nextInt();
                System.out.print("Enter columns for Matrix B: ");
                int p = sc.nextInt();
                
                System.out.println("\n--- Matrix A (" + m + "x" + n + ") ---");
                double[][] matrixA = readMatrix(m, n);
                
                System.out.println("\n--- Matrix B (" + n + "x" + p + ") ---");
                double[][] matrixB = readMatrix(n, p);
                
                double[][] product = multiplyMatrices(matrixA, matrixB);
                
                System.out.println("\n--- Product (A x B) ---");
                displayMatrix(product);
                break;
                
            case 2:
                System.out.print("Enter size of square matrix (2 or 3): ");
                int size = sc.nextInt();
                
                System.out.println("\n--- Matrix ---");
                double[][] matrix = readMatrix(size, size);
                double det = calculateDeterminant(matrix);
                
                System.out.println("\n--- Results ---");
                System.out.println("Determinant: " + String.format("%.2f", det));
                break;
                
            case 3:
                System.out.println("\n--- 2x2 Matrix ---");
                double[][] matrix2x2 = readMatrix(2, 2);
                double[][] inverse = inverseMatrix2x2(matrix2x2);
                
                if (inverse != null) {
                    System.out.println("\n--- Inverse Matrix ---");
                    displayMatrix(inverse);
                }
                break;
                
            default:
                System.out.println("Invalid choice!");
        }
    }
}
