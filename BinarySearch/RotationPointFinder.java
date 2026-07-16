public class RotationPointFinder {
    public static int findRotationPoint(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 6, 7, 1, 2, 3};
        int index = findRotationPoint(rotatedArray);
        System.out.println("Rotation point index: " + index);
        System.out.println("Smallest element: " + rotatedArray[index]);
    }
}
