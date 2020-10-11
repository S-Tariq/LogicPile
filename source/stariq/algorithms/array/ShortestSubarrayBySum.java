package stariq.algorithms.array;

// Find the shortest subarray based on the target sum provided.
// The array only contains positive integers. The methods fail if an array contains negative integers.
public class ShortestSubarrayBySum {

    public static void main(String[] args) {
        System.out.println("Equal to target:");

        // Target does not exist.
        int[] array = new int[] {1,4,0,3,0,7,3,1};
        System.out.println(shortestEqual(array, 6));

        // One single element equals target.
        array = new int[] {1,6,0,3,0,7,3,1};
        System.out.println(shortestEqual(array, 6));

        // Two single elements equal target.
        array = new int[] {1,6,0,3,6,7,3,1};
        System.out.println(shortestEqual(array, 6));

        // One subarray equals target.
        array = new int[] {1,4,0,3,0,7,5,1};
        System.out.println(shortestEqual(array, 6));

        // Two subarrays equal target.
        array = new int[] {1,3,0,3,0,7,5,1};
        System.out.println(shortestEqual(array, 6));

        // Three subarrays equal target.
        array = new int[] {1,3,0,3,0,7,1,5,7,3,1,1,1};
        System.out.println(shortestEqual(array, 6));

        // Contains negative values. One subarray equals target - Logic fails with negative value.
        array = new int[] {-4,0,3,3,7,5,7};
        System.out.println(shortestEqual(array, 6));

        //One element greater/equals target.
        array = new int[] {0,3,2,0,1,0};
        System.out.println(shortestGreaterThanOrEqual(array, 3));

        // One subarray greater/equals target.
        array = new int[] {0,1,2,0,1,0};
        System.out.println(shortestGreaterThanOrEqual(array, 3));

        // Two subarrays greater/equals target.
        array = new int[] {1,1,4,1,0,1,2};
        System.out.println(shortestGreaterThanOrEqual(array, 3));
    }

    public static int shortestEqual(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int shortLeft = -1;
        int shortRight = arr.length;
        while(right < arr.length) {
            sum += arr[right];
            while(left < right && sum > target) {
                sum -= arr[left];
                left++;
            }
            if(sum == target && shortRight - shortLeft > right - left) {
                shortLeft = left;
                shortRight = right;
            }
            right++;
        }
        if(shortRight == arr.length) {
            System.out.println("Target sum not found");
            return -1;
        }
        System.out.println(shortLeft + " " + shortRight);
        return shortRight - shortLeft + 1;
    }

    public static int shortestGreaterThanOrEqual(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int shortLeft = -1;
        int shortRight = arr.length;
        while(right < arr.length) {
            sum += arr[right];
            while(left < right && sum - arr[left] >= target) {
                sum -= arr[left];
                left++;
            }
            if(sum >= target && shortRight - shortLeft > right - left) {
                shortLeft = left;
                shortRight = right;
            }
            right++;
        }
        if(shortRight == arr.length) {
            System.out.println("Target sum not found");
            return -1;
        }
        System.out.println(shortLeft + " " + shortRight);
        return shortRight - shortLeft + 1;
    }
}
