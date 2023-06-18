package stariq.algorithms.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://www.hackerrank.com/challenges/countingsort1/problem
public class CountingSort {

    public static List<Integer> countingSort(List<Integer> arr) {
        int[] countIntegers = new int[100];
        for(Integer i: arr) {
            countIntegers[i]++;
        }
        return Arrays.stream(countIntegers).boxed().collect(Collectors.toList());
    }
}
