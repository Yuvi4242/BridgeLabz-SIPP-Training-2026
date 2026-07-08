import java.util.Scanner;

public class ScenarioQuestion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Merge Sort, Quick Sort, and Counting Sort Demo");
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array values:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] mergeSorted = copyArray(arr);
        mergeSort(mergeSorted, 0, mergeSorted.length - 1);
        System.out.println("Merge Sort result:");
        printArray(mergeSorted);

        int[] quickSorted = copyArray(arr);
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("Quick Sort result:");
        printArray(quickSorted);

        int[] countingSorted = copyArray(arr);
        countingSort(countingSorted);
        System.out.println("Counting Sort result:");
        printArray(countingSorted);

        System.out.println("\nExecution time comparison for input sizes 100, 1000, and 10000");
        comparePerformance();

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

    public static void countingSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        int[] count = new int[max + 1];
        for (int value : arr) {
            count[value]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void comparePerformance() {
        int[] sizes = {100, 1000, 10000};
        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = (int) (Math.random() * 100000);
            }

            long start = System.nanoTime();
            int[] mergeData = copyArray(data);
            mergeSort(mergeData, 0, mergeData.length - 1);
            long mergeTime = System.nanoTime() - start;

            start = System.nanoTime();
            int[] quickData = copyArray(data);
            quickSort(quickData, 0, quickData.length - 1);
            long quickTime = System.nanoTime() - start;

            start = System.nanoTime();
            int[] countData = copyArray(data);
            countingSort(countData);
            long countingTime = System.nanoTime() - start;

            System.out.println("Size " + size + " -> Merge: " + mergeTime + "ns, Quick: " + quickTime + "ns, Counting: " + countingTime + "ns");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// Time Complexity: Merge Sort O(n log n), Quick Sort O(n log n) average, Counting Sort O(n + k)
// Space Complexity: O(n) for merge arrays and temporary storage
