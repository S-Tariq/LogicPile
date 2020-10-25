package stariq.algorithms.array;

import java.util.HashSet;

public class PositionalElements {

    public static void main(String[] args) {
        int[][] array = new int[][] {{1,3,4}, {5,2,9}, {8,7,6}};
        System.out.println(positionalElements(array));
    }

    public static int positionalElements(int[][] arr) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < arr[i].length; j++) {
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
            set.add(min);
            set.add(max);
        }

        for(int i = 0; i < arr[i].length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < arr.length; j++) {
                min = Math.min(min, arr[j][i]);
                max = Math.max(max, arr[j][i]);
            }
            set.add(min);
            set.add(max);
        }
        return set.size();
    }
}
