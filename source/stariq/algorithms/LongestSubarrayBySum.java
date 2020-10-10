package stariq.algorithms;

public class LongestSubarrayBySum {

    public static void main(String[] args) {

        System.out.println("Equal to target:");

        int[] array = new int[] {1,2,0,3,0,7,5};
        System.out.println(longestEqualLength(array, 12));

        for(int i : longestEqualIndices(array,12)) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Greater than or equal to target:");

        int[] arr = new int[] {-1,-2,-4,3,2,0,1,-2};
        for(int i : longestGreaterEqual(arr,4)) {
            System.out.print(i + " ");
        }
    }

    // Brute approach - n squared time complexity which is really bad.
    public static int longestEqualLength(int[] arr, int target) {
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

    // Linear approach - n time complexity.
    // Can be amended to return length rather than indices by returning result[1] - result[0] + 1.
    public static int[] longestEqualIndices(int[] arr, int target) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int[] result = new int[] {-1,-1};
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
        return result;
    }

    // Linear approach
    public static int[] longestGreaterEqual(int[] arr, int target) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int[] result = new int[] {-1,-1};
        while(right < arr.length) {
            sum += arr[right];
            while(left < right && sum < target) {
                sum -= arr[left];
                left++;
            }
            if(sum >= target && result[1] - result[0] < right - left) {
                result = new int[] {left , right};
            }
            right++;
        }
        System.out.println(result[1] - result[0] + 1);
        return result;
    }
}
