package stariq.algorithms.array;

import java.util.List;

// https://www.hackerrank.com/challenges/diagonal-difference/problem
public class DiagonalDifference {

    public static void main(String[] args) {
        System.out.println(diagonalDifference(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(9, 8, 9))));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftToRightSum = 0;
        int rightToLeftSum = 0;

        for(int i = 0; i < arr.size(); i++) {
            leftToRightSum += arr.get(i).get(i);
            rightToLeftSum += arr.get(i).get(arr.size() - 1 - i);
        }
        return Math.abs(leftToRightSum - rightToLeftSum);
    }
}
