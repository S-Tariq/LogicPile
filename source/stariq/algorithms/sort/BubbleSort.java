package stariq.algorithms.sort;

// Bubble sort is the simplest sorting algorithm that works by repeatedly
// swapping the adjacent elements if they are in the wrong order.
// Time complexity: O(n^2)
// Space complexity: O(1)
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3,7,6,1,9,7,5,4,2,1,0};
        // sorted = {0,1,1,2,3,4,5,6,7,7,9}
        sort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    // In the nested for loop, - i is used as each loop pushes the largest value to be last element.
    // This means that the nested loop does not need to run more than necessary for the last set of elements.
}
