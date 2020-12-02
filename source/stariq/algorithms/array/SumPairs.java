package stariq.algorithms.array;

import java.util.ArrayList;
import java.util.List;

// Find pairs in an array which sum to a given number.
public class SumPairs {

    public static void main(String[] args) {
        int[] array = new int[]{2,4,3,7,2,1,4,5};
//        findPairsUsingLoops(array,8);
//        findPairsUsingLoops(array,4);
//        findPairsUsingLoops(array,28);
//        System.out.println("-------------");
//        findPairsUsingList(array,8);
//        findPairsUsingList(array,4);
//        findPairsUsingList(array,28);

        for(List<Integer> i : findPairs2(array, 8)) {
            System.out.print(i + " ");
        }
    }

    public static List<List<Integer>> findPairs(int[] arr, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> findPairs2(int[] arr, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(elements.contains(sum - arr[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(sum - arr[i]);
                list.add(arr[i]);
                result.add(list);
            } else {
                elements.add(arr[i]);
            }
        }
        return result;
    }

    // Using loops
    public static void findPairsUsingLoops(int[] arr, int sum) {
        int count = 0;
        StringBuilder pairs = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum) {
                    count++;
                    pairs.append("[");
                    pairs.append(arr[i]);
                    pairs.append(",");
                    pairs.append(arr[j]);
                    pairs.append("] ");
                    // pairs += "[" + arr[i] + "," + (sum-arr[i]) + "] ";
                }
            }
        }
        if(count == 0) {
            System.out.println("No pairs found for sum of " + sum);
        } else {
            System.out.println("Sum of " + sum + " has " + count + " pairs: " + pairs);
        }
    }

    public static void findPairsUsingList(int[] arr, int sum) {
        List<Integer> elements = new ArrayList<>();
        String pairs = "";
        for(int i = 0; i < arr.length; i++) {
            if(elements.contains(sum - arr[i])) {
                pairs += "[" + arr[i] + "," + (sum-arr[i]) + "] ";
            } else {
                elements.add(arr[i]);
            }
        }
        if(pairs.equals("")) {
            System.out.println("No pairs found for sum of " + sum);
        } else {
            System.out.println("Sum of " + sum + " has pairs: " + pairs);
        }

    }
}
