import java.util.Scanner;

public class BubbleSortStudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] marks = new int[n];
        System.out.println("Enter student marks:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        System.out.println("Original marks:");
        printArray(marks);

        bubbleSort(marks);

        System.out.println("Sorted marks:");
        printArray(marks);

        scanner.close();
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
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
