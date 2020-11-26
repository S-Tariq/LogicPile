package stariq.algorithms.sort;

// Insertion sort using binary search to find the position of the element.
// Time complexity: O(nlog(n))
// Space complexity: O(1)
public class BinaryInsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3,7,6,1,9,7,5,4,2,1,0};
        arr = new int[] {45, 62, 55, 14, 87, 21, 78, 39};
        binarySort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void binarySort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int position = binarySearch(arr, 0, i - 1, arr[i]);
            for(int j = i; j > position; j--) {
                arr[j] = arr[j - 1];
            }
            arr[position] = target;
        }
    }

    public static int binarySearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = (low + high) / 2;
            int midVal = arr[mid];
            if(midVal < target) {
                low = mid + 1;
            } else if (midVal > target){
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
