package stariq.algorithms.array;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Buy at a lower price and sell at a higher price - find the maximum profit.
public class BuySellStock {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(profit(prices));
        System.out.println(loss(prices));
    }

    public static int loss(int[] arr) {
        int loss = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : arr) {
            max = Math.max(max, i);
            loss = Math.min(loss, i - max);
        }
        return loss;
    }

    public static int profit(int[] arr) {
        int profit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : arr) {
            min = Math.min(min, i);
            profit = Math.max(profit, i - min);
        }
        return profit;
    }

    public static int profit2(int[] arr) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            min = Math.min(arr[i], min);
            if(min < arr[i + 1]) {
                profit = Math.max(arr[i + 1] - min, profit);
            }
        }
        return profit;
    }

    public static int profit3(int[] arr) {
        int profit = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    profit = Math.max(arr[j] - arr[i], profit);
                }
            }
        }
        return profit;
    }
}
