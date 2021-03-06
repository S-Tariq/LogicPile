package stariq.algorithms.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find the highest average of a student in a 2D array.
// Requires grouping the students based on their name, then calculating the average.
public class HighestAverage {

    public static void main(String[] args) {
        String[][] studentScores = {{"John", "85"}, {"Charlie", "60"}, {"Bob", "70"}, {"John", "97"}, {"Bob", "100"},
                {"Charlie", "50"}, {"Charlie", "100"}, {"Bob", "40"}};
        highestAverage(studentScores);
    }

    public static void highestAverage(String[][] scores) {
        Map<String, List<Integer>> studentRecord = new HashMap<>();

        for(String[] s : scores) {
            String key = s[0];
            Integer value = Integer.parseInt(s[1]);

            List<Integer> studentGrades = studentRecord.get(key);
            if(studentGrades == null) {
                studentGrades = new ArrayList<>();
                studentGrades.add(value);
                studentRecord.put(key, studentGrades);
            } else {
                studentGrades.add(value);
            }
        }

        int maxAverage = 0;
        String student = "";
        for(Map.Entry<String, List<Integer>> e : studentRecord.entrySet()) {
            int average = 0;
            for(int i : e.getValue()) {
                average += i;
            }
            average = average/e.getValue().size();
            if(average > maxAverage) {
                maxAverage = average;
                student = e.getKey();
            }
        }

        System.out.println(student + " : " + maxAverage);
    }

}
