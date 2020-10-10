package stariq.algorithms.array;

// Merge two sorted arrays into one sorted array.
public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,6,8,9};
        int[] arr2 = new int[]{0,2,4,7,10,12};

        for(int i : mergeTwoArrays(arr1,arr2)) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeTwoArrays(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                merged[k] = arr1[i];
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < arr1.length) {
            merged[k] = arr1[i];
            i++;
            k++;
        }

        while(j < arr2.length) {
            merged[k] = arr2[j];
            j++;
            k++;
        }
        return merged;
    }
}
