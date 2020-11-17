package stariq.algorithms.array;

// Find the largest subarray whose sum is equal to / less than or equal to target sum.
public class LargestSubarrayBySum {

    public static void main(String[] args) {

        System.out.println("Equal to target:");

        int[] array = new int[] {1,2,0,3,0,7,5};
//        System.out.println(longestEqual2(array, 12));

        for(int i : largestEqual(array,12)) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Greater than or equal to target:");

        int[] arr = new int[] {3,2,0,1};
        for(int i : largestLessThanOrEqual(arr,2)) {
            System.out.print(i + " ");
        }

        System.out.println();

        arr = new int[] {1,2,4,3,2,0,1,2};
        for(int i : largestLessThanOrEqual(arr,6)) {
            System.out.print(i + " ");
        }
    }

    // This method only works with positive integers.
    // Linear approach - n time complexity.
    // Can be amended to return length rather than indices by returning result[1] - result[0] + 1.
    public static int[] largestEqual(int[] arr, int target) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int[] result = new int[] {0,-1};
        while(right < arr.length) {
            sum += arr[right];
            while(left < right && sum > target) {
                sum -= arr[left];
                left++;
            }
            if(sum == target && result[1] - result[0] < right - left) {
                result = new int[]{left,right};
            }
            right++;
        }
        if(result[0] == -1) {
            System.out.println("Target sum not found.");
        }
        return result;
    }

    // Linear approach
    public static int[] largestLessThanOrEqual(int[] arr, int target) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int[] result = new int[] {0,-1};
        while(right < arr.length) {
            sum += arr[right];
            while(left < right && sum - arr[left] <= target) {
                sum -= arr[left];
                left++;
            }
            if(sum <= target && result[1] - result[0] < right - left) {
                result = new int[] {left , right};
            }
            right++;
        }
        if(result[1] == -1) {
            System.out.println("Target sum not found.");
        } else {
            System.out.println("Length: " + (result[1] - result[0] + 1));
        }
        return result;
    }

    // Brute approach - n squared time complexity which is really bad.
    public static int longestEqual2(int[] arr, int target) {
        int max = 0;
        for(int i = 0; i < arr.length - max; i++) {
            int sum = 0;
            int count = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                count++;
                if(sum == target) {
                    max = Math.max(count, max);
                    break;
                }
            }
        }
        return max;
    }
}
