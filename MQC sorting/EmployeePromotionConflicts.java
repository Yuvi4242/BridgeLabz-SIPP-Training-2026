import java.util.Scanner;

public class EmployeePromotionConflicts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter promotion scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int conflictCount = countConflicts(scores);
        System.out.println("Conflict count: " + conflictCount);

        scanner.close();
    }

    public static int countConflicts(int[] arr) {
        return countPairs(arr, 0, arr.length - 1);
    }

    public static int countPairs(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftCount = countPairs(arr, left, mid);
        int rightCount = countPairs(arr, mid + 1, right);
        int crossCount = countCrossPairs(arr, left, mid, right);
        merge(arr, left, mid, right);

        return leftCount + rightCount + crossCount;
    }

    public static int countCrossPairs(int[] arr, int left, int mid, int right) {
        int count = 0;
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                count += mid - i + 1;
                j++;
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
