import java.util.Arrays;

public class PairSumFraudDetection {
    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];
            if (sum == target) {
                return new int[]{transactions[left], transactions[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] transactions = {1000, 1500, 2000, 2500, 3000};
        int[] result = findPairSum(transactions, 4000);
        System.out.println("Pair found: " + Arrays.toString(result));
    }
}
