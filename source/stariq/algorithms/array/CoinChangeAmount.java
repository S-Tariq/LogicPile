package stariq.algorithms.array;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
// Find the fewest number of coins needed to make up a certain amount.
public class CoinChangeAmount {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,5};
        System.out.println(coinChange(array, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] temp = new int[amount + 1];
        Arrays.fill(temp, amount + 1);
        temp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int c : coins) {
                if(i - c >= 0) {
                    // 11
                    // 1 + temp[10]
                    // 1 + temp[9]
                    // 1 + temp[6]
                    temp[i] = Math.min(temp[i], 1 + temp[i - c]);
                }
            }
        }
        if(temp[amount] > amount) {
            return -1;
        }
        return temp[amount];
    }
}
