package sortingalgorithms;

// Time complexity: O(n log(n))
// Space complexity: O(1)

public class QuickSort {

    public static int[] quick(int[] arr, int start, int end) {

        int partition = partition(arr, start, end);

        if(partition - 1 > start) {
            quick(arr, start, partition - 1);
        }
        if(partition + 1 < end) {
            quick(arr, partition + 1, end);
        }

        return arr;
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        for(int i = start; i < end; i++){
            if(arr[i] < pivot) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }
}
