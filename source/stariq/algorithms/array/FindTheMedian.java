package stariq.algorithms.array;

import java.util.List;

// https://www.hackerrank.com/challenges/find-the-median/problem
// Sort the unsorted array then find the median
public class FindTheMedian {

    public static void main(String[] args) { // doesnt run for some reason
        System.out.println(findMedian(List.of(4, 5, 1, 7, 2)));
        System.out.println(findMedian(List.of(3, 6, 1, 2, 0, 5)));
    }

    public static int findMedian(List<Integer> arr) {
        // Bubble sort can cause time limit exceeded problem
        for(int i = 0; i < arr.size() - 1; i++) {
            for(int j = 0; j < arr.size() - 1 - i; j++) {
                if(arr.get(j) > arr.get(j + 1)) {
                    Integer temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sorted list: " + arr);
        int median = 0;
        int mid = arr.size()/2;
        if(arr.size() % 2 == 0) { // It is even so two middle numbers
            median = (arr.get(mid) + arr.get(mid - 1))/2;
        } else {
            median = arr.get(mid);
        }
        return median;
    }
}
