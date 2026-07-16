import java.util.Scanner;

public class QuickSortFlightTicketPrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of flights: ");
        int n = scanner.nextInt();

        int[] ticketPrices = new int[n];
        System.out.println("Enter ticket prices:");
        for (int i = 0; i < n; i++) {
            ticketPrices[i] = scanner.nextInt();
        }

        System.out.println("Original ticket prices:");
        printArray(ticketPrices);

        quickSort(ticketPrices, 0, ticketPrices.length - 1);

        System.out.println("Sorted ticket prices:");
        printArray(ticketPrices);

        scanner.close();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// Time Complexity: O(n log n) average, O(n^2) worst case
// Space Complexity: O(log n) recursion stack average
