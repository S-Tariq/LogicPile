package stariq.algorithms;

// Selection sort algorithm sorts an array by repeatedly finding the
// minimum element from unsorted part and putting it at the beginning.
// Time complexity: O(n^2)
// Space complexity: O(1)
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3,7,6,1,9,7,5,4,2,1,0};
        // sorted = {0,1,1,2,3,4,5,6,7,7,9}
        sort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    // Minimum element's index needs to be found to swap with the beginning element.
    // Temp is used to store the minimum element.
}
