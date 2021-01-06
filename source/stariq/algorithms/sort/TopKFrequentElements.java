package stariq.algorithms.sort;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] array = new int[] {1,1,1,2,2,3};
        for(int i : topKFrequent(array, 2)) {
            System.out.print(i + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(!list.contains(i)) {
                list.add(i);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int freqComp = Integer.compare(map.get(i2), map.get(i1));
                int numComp = Integer.compare(i1, i2);
                if(freqComp == 0) {
                    return numComp;
                }
                return freqComp;
            }
        });

        int[] result = new int[k];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
