import java.util.Scanner;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();

        int[] employeeIds = new int[n];
        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIds[i] = scanner.nextInt();
        }

        System.out.println("Original employee IDs:");
        printArray(employeeIds);

        insertionSort(employeeIds);

        System.out.println("Sorted employee IDs:");
        printArray(employeeIds);

        scanner.close();
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
