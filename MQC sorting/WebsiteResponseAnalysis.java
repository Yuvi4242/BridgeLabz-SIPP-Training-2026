import java.util.Scanner;

public class WebsiteResponseAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of response times: ");
        int n = scanner.nextInt();

        int[] responseTimes = new int[n];
        System.out.println("Enter response times:");
        for (int i = 0; i < n; i++) {
            responseTimes[i] = scanner.nextInt();
        }

        int inversionCount = countInversions(responseTimes);
        System.out.println("Inversion count: " + inversionCount);

        scanner.close();
    }

    public static int countInversions(int[] arr) {
        return countInversions(arr, 0, arr.length - 1);
    }

    public static int countInversions(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftInversions = countInversions(arr, left, mid);
        int rightInversions = countInversions(arr, mid + 1, right);
        int crossInversions = mergeAndCount(arr, left, mid, right);

        return leftInversions + rightInversions + crossInversions;
    }

    public static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        int inversions = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
                inversions += leftArray.length - i;
            }
        }

        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }

        return inversions;
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(n)
