package stariq.algorithms.sort;

// Quick sort is a divide and conquer algorithm.
// It picks an element as a pivot and partitions the given array around the pivot.
// Pivot can be the first or last element.
// Time complexity: O(nlog(n))
// Space complexity: O(n)
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3,7,6,1,9,7,5,2,0,4};
        // sorted = {0,1,1,2,3,4,5,6,7,7,9}
        sort(arr, 0, arr.length - 1);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr, int start, int end) {
        int pivotIndex = partition(arr, start, end);

        if(pivotIndex - 1 > start) {
            sort(arr, start, pivotIndex - 1);
        }
        if(pivotIndex + 1 < end) {
            sort(arr, pivotIndex + 1, end);
        }
    }
    // First if statement deals with the left side of the pivot.
    // Second if statement deals with the right side of the pivot.
    // The -1 & +1 is there to ignore the pivot element which already gets sorted by the partition.
    // The if statements ensure if there is only one element present on either side,
    // then it does not need to be sorted.

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        for(int i = start; i < end; i++) {
            if(arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                start++;
            }
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        return start;
    }
    // Pivot: Last element
    // The loop starts swapping all the elements less than the pivot by moving it to the left side.
    // The start index gets incremented until it reaches the point where the pivot should be.
    // After loop, the pivot element is moved to its correct position.
}


