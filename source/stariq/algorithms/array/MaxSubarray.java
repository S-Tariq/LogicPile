package stariq.algorithms.array;

// https://leetcode.com/problems/maximum-subarray/
public class MaxSubarray {

    public static void main(String[] args) {
        int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarray(arr));
    }

    public static int maxSubarray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
