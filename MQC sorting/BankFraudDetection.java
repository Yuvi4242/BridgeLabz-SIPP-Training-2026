import java.util.Scanner;

public class BankFraudDetection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of amounts: ");
        int n = scanner.nextInt();

        int[] amounts = new int[n];
        System.out.println("Enter amounts:");
        for (int i = 0; i < n; i++) {
            amounts[i] = scanner.nextInt();
        }

        long pairCount = countFraudPairs(amounts);
        System.out.println("Number of suspicious pairs: " + pairCount);

        scanner.close();
    }

    public static long countFraudPairs(int[] arr) {
        return countPairs(arr, 0, arr.length - 1);
    }

    public static long countPairs(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        long leftPairs = countPairs(arr, left, mid);
        long rightPairs = countPairs(arr, mid + 1, right);
        long crossPairs = countCrossPairs(arr, left, mid, right);
        merge(arr, left, mid, right);

        return leftPairs + rightPairs + crossPairs;
    }

    public static long countCrossPairs(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        long count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] > 3 * (long) arr[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        return count;
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
}

// Time Complexity: O(n log n)
// Space Complexity: O(n)
