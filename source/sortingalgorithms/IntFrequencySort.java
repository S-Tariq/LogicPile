package sortingalgorithms;


import java.util.*;

public class IntFrequencySort {

    public static int[] intFrequency(int[] arr) {


        List<Integer> list = new ArrayList<>();

        for(int i : arr) {
            list.add(i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : list) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int freqComp = map.get(i1).compareTo(map.get(i2));
                int numComp = i1.compareTo(i2);
                if(freqComp == 0) {
                    return numComp;
                } else {
                    return freqComp;
                }
            }
        });

        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

}
