package stariq.algorithms.array;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Binary search is logn whereas other is n.
// Example:
// 1 2 3 4 5 - left
// 5 1 2 3 4 - left
// 4 5 1 2 3 - left
// 3 4 5 1 2 - right
// 2 3 4 5 1 - right
public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5};
        System.out.println(findMinBS(array));
        array = new int[] {5,1,2,3,4};
        System.out.println(findMinBS(array));
        array = new int[] {4,5,1,2,3};
        System.out.println(findMinBS(array));
        array = new int[] {3,4,5,1,2};
        System.out.println(findMinBS(array));
        array = new int[] {2,3,4,5,1};
        System.out.println(findMinBS(array));

    }

    public static int findMinBS(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = (low + high)/2;
            if(nums[mid] > nums[high]) {
                // Right side
                low = mid + 1;
            } else {
                // Left side
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
