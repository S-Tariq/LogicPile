package stariq.algorithms;

// Find the second smallest element in an array.
public class SecondSmallest {

    public static void main(String[] args) {
        int[] array = {2,5,1,6,9,0,-1,-3,-8,-10,-10};
        SecondSmallest.secondSmallestInteger(array);
        SecondSmallest.secondSmallestInteger(new int[] {1,6,3,9,-9,2,0});
        SecondSmallest.secondSmallestInteger(new int[] {1});
        SecondSmallest.secondSmallestInteger(new int[] {1,-1});
        SecondSmallest.secondSmallestInteger(new int[] {3,-5,-9});
    }

    public static void secondSmallestInteger(int[] arr) {
        if(arr.length > 2) {
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] < first) {
                    second = first;
                    first = arr[i];
                } else if (arr[i] < second && arr[i] > first) {
                    second = arr[i];
                }
            }
            System.out.println(second);
        } else {
            System.out.println("Invalid array");
        }
    }
}
