package stariq.algorithms.array;

// Bitonic array: Increasing order then decreasing order in an array.
public class FindTargetInBitonicArray {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,3,1,0};
        System.out.println(foundTarget(array, 5));
        System.out.println(foundTargetBS(array, 5));
    }

    // Linear approach
    public static int foundTarget(int[] array, int target) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Logn approach
    public static int foundTargetBS(int[] array, int target) {
        int bitonicIndex =  maxElementBS(array, 0, array.length - 1);
        if(target > array[bitonicIndex]) {
            return -1;
        } else if (target == array[bitonicIndex]) {
            return bitonicIndex;
        } else {
            int index = ascBinarySearch(array, 0, bitonicIndex - 1, target);
            if(index != -1) {
                return index;
            }
            index = descBinarySearch(array, bitonicIndex + 1, array.length - 1, target);
            return index;
        }
    }

    public static int maxElementBS(int[] array, int low, int high) {
        while(low <= high) {
            int mid = (low + high)/2;
            if(array[mid] > array[mid-1] && array[mid] > array[mid+1]) {
                return mid;
            } else if (array[mid] > array[mid-1] && array[mid] < array[mid+1]) {
                low = mid + 1;
            } else if (array[mid] < array[mid-1] && array[mid] > array[mid+1]) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int ascBinarySearch(int[] array, int low, int high, int target) {
        while(low <= high) {
            int mid = (low + high)/2;
            if(target > array[mid]) {
                low = mid + 1;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int descBinarySearch(int[] array, int low, int high, int target) {
        while(low <= high) {
            int mid = (low + high)/2;
            if(target > array[mid]) {
                high = mid - 1;
            } else if (target < array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
