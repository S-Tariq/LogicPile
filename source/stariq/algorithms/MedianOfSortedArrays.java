package stariq.algorithms;

public class MedianOfSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,4,6};
        int[] arr2 = new int[] {2,4,6,7,9,10};
        System.out.println(median(arr1,arr2));
        arr1 = new int[] {1,2,3,4};
        arr2 = new int[] {2,3,4,5,6};
        System.out.println(median(arr1,arr2));
    }

    public static int median(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        while(i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while(j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        int mid = merged.length/2;
        if(merged.length % 2 == 0) {
            return (merged[mid - 1] + merged[mid])/2;
        } else {
            return merged[mid];
        }
    }
}


