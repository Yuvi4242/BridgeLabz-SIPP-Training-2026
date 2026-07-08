import java.util.Scanner;

public class MergeCustomerRecords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of first sorted array: ");
        int n1 = scanner.nextInt();
        int[] firstArray = new int[n1];
        System.out.println("Enter first sorted array values:");
        for (int i = 0; i < n1; i++) {
            firstArray[i] = scanner.nextInt();
        }

        System.out.print("Enter size of second sorted array: ");
        int n2 = scanner.nextInt();
        int[] secondArray = new int[n2];
        System.out.println("Enter second sorted array values:");
        for (int i = 0; i < n2; i++) {
            secondArray[i] = scanner.nextInt();
        }

        int[] mergedArray = mergeSortedArrays(firstArray, secondArray);
        System.out.println("Merged array:");
        printArray(mergedArray);

        scanner.close();
    }

    public static int[] mergeSortedArrays(int[] firstArray, int[] secondArray) {
        int[] merged = new int[firstArray.length + secondArray.length];
        int i = 0, j = 0, k = 0;

        while (i < firstArray.length && j < secondArray.length) {
            if (firstArray[i] <= secondArray[j]) {
                merged[k++] = firstArray[i++];
            } else {
                merged[k++] = secondArray[j++];
            }
        }

        while (i < firstArray.length) {
            merged[k++] = firstArray[i++];
        }

        while (j < secondArray.length) {
            merged[k++] = secondArray[j++];
        }

        return merged;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// Time Complexity: O(n + m)
// Space Complexity: O(n + m)
