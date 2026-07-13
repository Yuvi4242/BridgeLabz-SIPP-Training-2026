import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] result = obj.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
