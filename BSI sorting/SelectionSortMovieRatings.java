import java.util.Scanner;

public class SelectionSortMovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of movies: ");
        int n = scanner.nextInt();

        int[] ratings = new int[n];
        System.out.println("Enter movie ratings:");
        for (int i = 0; i < n; i++) {
            ratings[i] = scanner.nextInt();
        }

        System.out.println("Original ratings:");
        printArray(ratings);

        selectionSort(ratings);

        System.out.println("Sorted ratings:");
        printArray(ratings);

        scanner.close();
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
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
