public class PeakElementFinder {
    public static int findPeak(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftOk = (mid == 0) || (arr[mid] >= arr[mid - 1]);
            boolean rightOk = (mid == arr.length - 1) || (arr[mid] >= arr[mid + 1]);

            if (leftOk && rightOk) {
                return mid;
            }

            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 0};
        int peakIndex = findPeak(nums);
        System.out.println("Peak index: " + peakIndex);
        System.out.println("Peak value: " + nums[peakIndex]);
    }
}
