package stariq.algorithms.sort;

// Sort array based on the size of the strings.
// If strings have the same size, sort in lexicographical order.
public class SizeSort {

    public static void main(String[] args) {
        String[] array = new String[] {"your", "hello", "dry", "cry", "fry"};
        bubbleSizeSort(array);
        for(String s : array) {
            System.out.print(s + " ");
        }

        System.out.println();

        String[] arr = new String[] {"your", "fry", "hello", "yes", "to", "cry", "dry", "so"};
        mergeSizeSort(arr, arr.length);
        for(String s : arr) {
            System.out.print(s + " ");
        }
    }

    public static void bubbleSizeSort(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j].length() > arr[j + 1].length()) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                if(arr[j].length() == arr[j+1].length()) {
                    if(arr[j].compareTo(arr[j+1]) > 0) {
                        String temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void mergeSizeSort(String[] arr, int length) {
        if(length < 2) {
            return;
        }
        int mid = length/2;
        String[] left = new String[mid];
        String[] right = new String[length-mid];
        for(int i = 0; i < arr.length; i++) {
            if(i < mid) {
                left[i] = arr[i];
            } else {
                right[i - mid] = arr[i];
            }
        }
        mergeSizeSort(left, mid);
        mergeSizeSort(right, length - mid);
        merge(arr, left, right, mid, length - mid);
    }

    public static void merge(String[] arr, String left[], String right[], int l, int r) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < l && j < r) {
            if(left[i].length() < right[j].length()) {
                arr[k++] = left[i++];
            } else if (right[j].length() < left[i].length()){
                arr[k++] = right[j++];
            } else {
                if(left[i].compareTo(right[j]) < 0) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
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
