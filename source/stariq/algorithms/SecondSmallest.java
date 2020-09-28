package stariq.algorithms;

public class SecondSmallest {

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
