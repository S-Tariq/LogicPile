package sortingalgorithms;

public class SelectionSort {


    public static int[] selection(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }

}
