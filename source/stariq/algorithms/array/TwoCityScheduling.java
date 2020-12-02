package stariq.algorithms.array;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/two-city-scheduling/
public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] array = new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        array = new int[][]{{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}};
        array = new int[][]{{10,20},{30,200},{400,50},{30,20}};
        System.out.println(twoCitySchedCost(array));
    }

    // No repeated code.
    public static int twoCitySchedCost(int[][] costs) {
        // Array is sorted by biggest difference to smallest difference.
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int diffA = Math.abs(a[0] - a[1]);
                int diffB = Math.abs(b[0] - b[1]);
                return Integer.compare(diffB, diffA);
            }
        });

        int countA = 0;
        int countB = 0;
        int max = costs.length/2;
        int minCost = 0;
        for(int[] cost : costs) {
            if((countA < max && cost[0] < cost[1]) || countB == max) {
                minCost += cost[0];
                countA++;
                // Else if is used instead of if because we do not want values added twice from the same subset.
                // That can happen when countA equals mid because of incrementation and the second if statement
                // gets processed as it meets the second condition.
            } else if((countB < max && cost[0] >= cost[1]) || countA == max) {
                minCost += cost[1];
                countB++;
            }
        }
        return minCost;
    }

    // Repeated code present in the if statement conditions.
    public static int twoCityCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int diffA = Math.abs(a[0] - a[1]);
                int diffB = Math.abs(b[0] - b[1]);
                return Integer.compare(diffB, diffA);
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
