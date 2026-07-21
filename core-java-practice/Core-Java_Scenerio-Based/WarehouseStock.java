import java.util.Arrays;

public class WarehouseStock {
    public static void main(String[] args) {
        int[] stock = {25, 40, 25, 80, 10, 40, 55, 90, 10, 70};
        int max = stock[0];
        int min = stock[0];
        int total = 0;
        boolean duplicate = false;
        for (int i = 0; i < stock.length; i++) {
            total += stock[i];
            if (stock[i] > max) {
                max = stock[i];
            }
            if (stock[i] < min) {
                min = stock[i];
            }
            for (int j = i + 1; j < stock.length; j++) {
                if (stock[i] == stock[j]) {
                    duplicate = true;
                }
            }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(total);
        System.out.println(duplicate ? "Duplicate Found" : "No Duplicates");
        int k = 3;
        rotate(stock, k);
        System.out.println(Arrays.toString(stock));
        int[][] shelf = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposed = transpose(shelf);
        for (int[] row : transposed) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void rotate(int[] arr, int k) {
        k %= arr.length;
        if (k < 0) {
            k += arr.length;
        }
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
