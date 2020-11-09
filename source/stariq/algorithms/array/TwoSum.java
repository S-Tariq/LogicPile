package stariq.algorithms.array;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/
public class TwoSum {

    public static void main(String[] args) {
        int[] array = new int[] {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(array, 18)));
    }

    // O(n)
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                int index = map.get(target - nums[i]);
                result[0] = index;
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    // Takes too long - O(n^2)
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
