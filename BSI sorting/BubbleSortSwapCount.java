import java.util.Scanner;

public class BubbleSortSwapCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array values:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int swapCount = bubbleSortWithCount(arr);
        System.out.println("Sorted array:");
        printArray(arr);
        System.out.println("Total swaps: " + swapCount);

        scanner.close();
    }

    public static int bubbleSortWithCount(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swaps++;
                }
            }
        }
        return swaps;
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

// Time Complexity: O(n^2)
// Space Complexity: O(1)
