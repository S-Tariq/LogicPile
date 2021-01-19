package stariq.algorithms.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

// Given a list of operation hour for each stock exchange,
// validate if the customer can send a trading order during the input hour.
/*
 Operation hours:
 09:00-16:00 Royal Bank of Scotland
 11:00-17:00 Morgan Stanley

 Test case #1 - expected result: SUCCESS
 10:00-17:00

 Test case #2 - expected result: FAILURE
 15:00-21:00
 */
public class MergeOperationHours {

    public static void main(String[] args) {
        int[][] hours = new int[][] {{9, 16}, {11,17}};
        System.out.println(validateOrder(hours, new int[] {10,17}));
        System.out.println(validateOrder(hours, new int[] {15,21}));
    }

    public static boolean validateOrder(int[][] hours, int[] order) {
        if(hours.length == 0) {
            return false;
        }

        Arrays.sort(hours, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        Stack<int[]> stack = new Stack<>();
        for(int[] i : hours) {
            if(!stack.isEmpty() && stack.peek()[1] >= i[0]) {
                stack.peek()[1] = Math.max(stack.peek()[1], i[1]);
            } else {
                stack.push(i);
            }
        }

        for(int[] hour : stack) {
            if(hour[0] <= order[0] && hour[1] >= order[1]) {
                return true;
            }
        }

        return false;
    }

}
