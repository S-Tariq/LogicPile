package stariq.algorithms.array;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesInSortedArray {

    public static void main(String[] args) {
        int[] array = new int[] {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates2(array);
        for(int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int len = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i + 1]) {
                nums[len] = nums[i + 1];
                len++;
            }
        }
        return len;
    }

    public static int removeDuplicates2(int[] nums) {
        TreeMap<Integer, Integer> numCount = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for(Map.Entry<Integer, Integer> e: numCount.entrySet()) {
            nums[i++] = e.getKey();
        }

        return numCount.size();
    }
}
