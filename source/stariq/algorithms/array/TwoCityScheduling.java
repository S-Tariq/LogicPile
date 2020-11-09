package stariq.algorithms.array;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/two-city-scheduling/
public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] array = new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        array = new int[][]{{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}};
        System.out.println(twoCityCost(array));
    }

    public static int twoCityCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff1 = Math.abs(o1[0] - o1[1]);
                int diff2 = Math.abs(o2[0] - o2[1]);
                return Integer.compare(diff2, diff1);
            }
        });

        int countA = 0;
        int countB = 0;
        int max = costs.length/2;
        int minCost = 0;
        for(int[] cost : costs) {
            if(countA < max && cost[0] < cost[1]) {
                minCost += cost[0];
                countA++;
            } else if (countA == max && countB < max){
                minCost += cost[1];
                countB++;
            } else if(countB < max && cost[0] >= cost[1]) {
                minCost += cost[1];
                countB++;
            } else if (countB == max && countA < max) {
                minCost += cost[0];
                countA++;
            }
        }
        return minCost;
    }
}
