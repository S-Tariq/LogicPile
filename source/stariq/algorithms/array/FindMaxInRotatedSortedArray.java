package stariq.algorithms.array;

public class FindMaxInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = new int[] {3,4,5,1,2};
        System.out.println(findMaxBS(array));
    }

    public static int findMaxBS(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while(low < high) {
            int mid = (low + high)/2;
            if(array[mid] > array[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        // Can return either low or high since the loop stops when they are equal.
        return array[high];
    }
}
