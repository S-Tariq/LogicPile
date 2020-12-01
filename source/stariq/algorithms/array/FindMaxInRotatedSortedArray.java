package stariq.algorithms.array;

// Binary search is logn whereas other is n.
// Example:
// 5 1 2 3 4 - left
// 4 5 1 2 3 - left
// 3 4 5 1 2 - right
// 2 3 4 5 1 - right
// 1 2 3 4 5 - right
public class FindMaxInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = new int[] {6,5,1,2,3,4};
        System.out.println(findMaxBS(array));
        array = new int[] {4,5,6,1,2,3};
        System.out.println(findMaxBS(array));
        array = new int[] {3,4,5,6,1,2};
        System.out.println(findMaxBS(array));
        array = new int[] {2,3,4,5,6,1};
        System.out.println(findMaxBS(array));
        array = new int[] {1,2,3,4,5,6};
        System.out.println(findMaxBS(array));
    }

    public static int findMaxBS(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = (low + high)/2 + 1;
            if(nums[mid] < nums[low]) {
                // Left side
                high = mid - 1;
            } else {
                // Right side
                low = mid;
            }
        }
        // Can return either low or high since the loop stops when they are equal.
        return nums[low];
    }
}
