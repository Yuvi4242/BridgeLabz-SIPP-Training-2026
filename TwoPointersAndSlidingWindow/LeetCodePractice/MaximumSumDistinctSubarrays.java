import java.util.HashMap;
import java.util.Map;

public class MaximumSumDistinctSubarrays {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long sum = 0;
        long maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];

            while (freq.size() > k) {
                int leftValue = nums[left];
                sum -= leftValue;
                freq.put(leftValue, freq.get(leftValue) - 1);
                if (freq.get(leftValue) == 0) {
                    freq.remove(leftValue);
                }
                left++;
            }

            if (freq.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumDistinctSubarrays obj = new MaximumSumDistinctSubarrays();
        System.out.println(obj.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
    }
}
