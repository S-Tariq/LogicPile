package stariq.algorithms.array;

import java.util.*;

// Find the average score of each student's top five scores in the order of their student id.
public class TopFiveAverage {

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,91}, {1,92}, {2,93}, {2,97}, {1,60}, {2,77},
                {1,65}, {1,87}, {1,100}, {2,100}, {2,76}};

        int[][] result = topFive(arr);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] topFive(int[][] arr) {
        TreeMap<Integer, PriorityQueue<Integer>> recordsMap = new TreeMap<>();

        for(int[] item : arr) {
            int id = item[0];
            int score = item[1];
            PriorityQueue<Integer> scoresQueue;
            if(recordsMap.containsKey(id)) {
                scoresQueue = recordsMap.get(id);
                scoresQueue.offer(score);
                if(scoresQueue.size() > 5) {
                    scoresQueue.poll();
                }
                recordsMap.put(id, scoresQueue);
            } else {
                scoresQueue = new PriorityQueue<>();
                scoresQueue.offer(score);
                recordsMap.put(id, scoresQueue);
            }
        }

        int[][] result = new int[recordsMap.size()][2];
        for(int id : recordsMap.keySet()) {
            PriorityQueue<Integer> scoresQueue = recordsMap.get(id);
            int sum = 0;
            while(!scoresQueue.isEmpty()) {
                sum += scoresQueue.poll();
            }
            result[id - 1][0] = id;
            result[id - 1][1] = sum / 5;

        }
        return result;
    }
}
