import java.util.Scanner;

public class HospitalEmergency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = scanner.nextInt();

        int[] priorities = new int[n];
        System.out.println("Enter patient priorities:");
        for (int i = 0; i < n; i++) {
            priorities[i] = scanner.nextInt();
        }

        System.out.print("Enter k for kth highest priority: ");
        int k = scanner.nextInt();

        int kthHighest = quickSelect(priorities, 0, priorities.length - 1, k);
        System.out.println("The " + k + "th highest priority is: " + kthHighest);

        scanner.close();
    }

    public static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        int pivotIndex = partition(arr, low, high);
        if (pivotIndex == k - 1) {
            return arr[pivotIndex];
        } else if (pivotIndex > k - 1) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
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
}

// Time Complexity: O(n) average for Quick Select
// Space Complexity: O(1) extra space (excluding recursion stack)
