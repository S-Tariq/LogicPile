package stariq.algorithms.array;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,7,0,1,2};
        array = new int[]{1,3};
        System.out.println(search(array, 3));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > nums[high]) {
                // > nums[high] can be changed to >= nums[low]
                if(target < nums[mid] && target > nums[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
