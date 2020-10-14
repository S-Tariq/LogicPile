package stariq.algorithms.array;

// Find the longest non-contiguous increasing subsequence in an array.
public class LongestIncreasingSequence {

    public static void main(String[] args) {
        int[] array = new int[] {2,4,3,7,4,5};
        array = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(longestSequenceBinarySearch(array));
        System.out.println(longestSequenceTail(array));
    }

    // If x is larger than all tails, append it, increase the size by 1.
    // If tails[i - 1] is less than x and tails[i] is greater than or equal to x, update tails[i].
    public static int longestSequenceTail(int[] arr) {
        int[] tails = new int[arr.length];
        int size = 0;
        for(int x : arr) {
            int i = 0;
            int j = size;
            while(i != j) {
                int m = (i + j) / 2;
                if(tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if(i == size) {
                size++;
            }
        }
        return size;
    }

    public static int longestSequenceBinarySearch(int[] arr) {
        // Increasing array.
        int[] temp = new int[arr.length];
        int len = 0;
        for(int x : arr) {
            int i = binarySearch(temp, 0, len - 1, x);
            temp[i] = x;
            if(i == len) {
                len++;
            }
        }
        return len;
    }

    private static int binarySearch(int[] a, int low, int high, int target) {

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = a[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid;
        }
        // Target not found.
        return low;
    }
}
