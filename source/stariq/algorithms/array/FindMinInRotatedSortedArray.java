package stariq.algorithms.array;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Both methods work.
public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = new int[] {3,4,5,1,2};
        System.out.println(findMinBS(array));
    }

    public static int findMinBS(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = (low + high)/2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // Can return either low or high since the loop stops when they are equal.
        return nums[high];
    }

    public static int findMin2(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }
}
