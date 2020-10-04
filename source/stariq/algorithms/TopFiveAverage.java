package stariq.algorithms;

import java.util.*;

public class TopFiveAverage {

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,91}, {1,92}, {2,93}, {2,97}, {1,60}, {2,77},
                {1,65}, {1,87}, {1,100}, {2,100}, {2,76}};
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] topFive(int[][] arr) {
        Map<Integer, List<Integer>> record = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            List<Integer> scores = record.get(arr[i][1]);
            if(scores == null) {
                scores = new ArrayList<>();
                scores.add(arr[i][1]);
                record.put(arr[i][0], scores);
            } else {
                scores.add(arr[i][1]);
            }
        }

        for(Map.Entry<Integer, List<Integer>> e : record.entrySet()) {
            if(e.getValue().size() <= 5) {
                continue;
            } else {
                Collections.sort(e.getValue());
            }
        }


        return new int[1][1];
    }
}
