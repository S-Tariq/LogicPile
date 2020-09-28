package stariq.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SumPairs {

    public static void main(String[] args) {
        int[] array = new int[]{2,4,3,7,2,1,4,5};
        findPairsUsingLoops(array,8);
        findPairsUsingLoops(array,4);
        findPairsUsingLoops(array,28);
        System.out.println("-------------");
        findPairsUsingList(array,8);
        findPairsUsingList(array,4);
        findPairsUsingList(array,28);
    }

    // Using loops
    public static void findPairsUsingLoops(int[] arr, int sum) {
        int count = 0;
        String pairs = "";
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum) {
                    count++;
                    pairs += "[" + arr[i] + "," + arr[j] + "] ";
                    //System.out.println(arr[i] + " + "  + arr[j] + " = " + sum);
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
