package algorithms;

public class SortArray {

    // Print array elements
    public static void print(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
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

    // Quick Sort
    public static void quickSort(int[] arr, int start, int end) {
        int pivotIndex = partition(arr, start, end);
        if(pivotIndex - 1 > start) {
            quickSort(arr, start, pivotIndex - 1);
        }
        if(pivotIndex + 1 < end) {
            quickSort(arr, pivotIndex + 1, end);
        }
    }

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

    // Merge Sort
    public static void mergeSort(int[] arr, int length) {
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
        mergeSort(left, mid);
        mergeSort(right, length - mid);
        merge(arr, left, right, mid, length - mid);
    }

    private static void merge(int[] arr, int[] left, int[] right, int l, int r) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < l && j < r) {
            if(left[i] <= right[j]) {
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

}

