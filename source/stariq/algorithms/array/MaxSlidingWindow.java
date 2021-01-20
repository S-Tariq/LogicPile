package stariq.algorithms.array;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/sliding-window-maximum/
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        for(int i : maxSlidingWindow2(nums, 3)) {
            System.out.print(i + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        // Index for result
        int j = 0;
        // Stores indexes
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            // Removes from head - removes number out of range k
            if(!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            // Removes from tail - removes smaller numbers in k range
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1) {
                result[j++] = nums[queue.peek()];
            }
        }
        return result;
    }

    // Works but time exceeded.
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int l = 0;
        for(int i = 0; i < nums.length - k  + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[l++] = max;
        }
        return result;
    }
}
