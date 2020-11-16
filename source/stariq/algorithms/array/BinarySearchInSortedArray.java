package stariq.algorithms.array;

// https://leetcode.com/problems/binary-search/
public class BinarySearchInSortedArray {

    public static void main(String[] args) {
        int[] array = new int[]{-1,0,3,5,9,12};
        System.out.println(search(array, 9));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            // To prevent integer overflow -> int mid = low + (high-low)/2;
            int mid = (low + high)/2;
            if(target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
