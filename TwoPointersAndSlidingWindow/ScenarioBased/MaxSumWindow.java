public class MaxSumWindow {
    public static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        if (cpuLoad == null || cpuLoad.length < k) {
            return -1;
        }

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= cpuLoad[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] cpuLoad = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSubarrayOfSizeK(cpuLoad, 3));
    }
}
