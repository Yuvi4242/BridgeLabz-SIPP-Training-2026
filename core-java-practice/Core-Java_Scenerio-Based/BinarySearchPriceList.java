import java.util.Scanner;

public class BinarySearchPriceList {

    public static int binarySearch(int[] prices, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (prices[mid] == target) {
            return mid;
        }
        if (prices[mid] > target) {
            return binarySearch(prices, target, left, mid - 1);
        }
        return binarySearch(prices, target, mid + 1, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int result = binarySearch(prices, target, 0, n - 1);
        System.out.println(result);
        scanner.close();
    }
}
