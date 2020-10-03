package stariq.algorithms.sort;

// Merge sort is a divide and conquer algorithm.
// It divides the array in two halves, calls itself for the two halves
// and then merges the two sorted halves.
// Time complexity: O(nlog(n))
// Space complexity: O(n)
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3,7,6,1,9,7,5,4,2,1,0};
        // sorted = {0,1,1,2,3,4,5,6,7,7,9}
        sort(arr, arr.length);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr, int length) {
        if(length < 2) {
            return;
        }

        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for(int i = 0; i < length; i++) {
            if(i < mid) {
                left[i] = arr[i];
            } else {
                right[i - mid] = arr[i];
            }
        }
        sort(left,mid);
        sort(right,length-mid);
        merge(arr, left, right, mid, length-mid);
    }
    // Focuses on splitting the left side before the right side.
    // When merge happens in left, it moves to right side to bring it to the same merge level.

    private static void merge(int[] arr, int[] left, int[] right, int l, int r) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < l && j < r) {
            if(left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while(i < l) {
            arr[k++] = left[i++];
        }

        while(j < r) {
            arr[k++] = right[j++];
        }
    }
    // Merges left and right side in order.
    // First loop runs when both arrays have elements left to merge.
    // Moves onto the last two loops depending on which array still has elements left.
}
