package stariq.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighestAverage {

    public static void highestAverage(String[][] scores) {
        Map<String, List<Integer>> studentRecord = new HashMap<>();

        for(int i = 0; i < scores.length; i++) {
            String key = scores[i][0];
            Integer value = Integer.parseInt(scores[i][1]);

            List<Integer> studentGrades = studentRecord.get(key);
            if(studentGrades == null) {
                studentGrades = new ArrayList<>();
                studentGrades.add(value);
                studentRecord.put(key, studentGrades);
            } else {
                studentGrades.add(value);
            }
        }

        //Map<String, Integer> studentAverage = new HashMap<>();
        int maxAverage = 0;
        String student = "";
        for(Map.Entry<String, List<Integer>> e : studentRecord.entrySet()) {
            int sum = 0;
            for(int i : e.getValue()) {
                sum += i;
            }

            //studentAverage.put(e.getKey(), sum/studentRecord.get(e.getKey()).size());
            if(sum/studentRecord.get(e.getKey()).size() > maxAverage) {
                maxAverage = sum/studentRecord.get(e.getKey()).size();
                student = e.getKey();
            }
        }

        System.out.println(student + " : " + maxAverage);
        //for(Map.Entry<String, Integer> e : studentAverage.entrySet()) {
        //System.out.println(e.getKey() + " " + e.getValue());
        //}
    }

}
