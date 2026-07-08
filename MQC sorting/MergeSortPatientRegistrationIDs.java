import java.util.Scanner;

public class MergeSortPatientRegistrationIDs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = scanner.nextInt();

        int[] registrationIds = new int[n];
        System.out.println("Enter registration IDs:");
        for (int i = 0; i < n; i++) {
            registrationIds[i] = scanner.nextInt();
        }

        System.out.println("Original registration IDs:");
        printArray(registrationIds);

        mergeSort(registrationIds, 0, registrationIds.length - 1);

        System.out.println("Sorted registration IDs:");
        printArray(registrationIds);

        scanner.close();
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(n)
