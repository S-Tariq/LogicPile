package stariq.algorithms;

// Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
// You pick an unsorted element and insert it into sorted sequence before that element's position.
// Time complexity: O(n^2)
// Space complexity: O(1)
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3,7,6,1,9,7,5,4,2,1,0};
        // sorted = {0,1,1,2,3,4,5,6,7,7,9}
        sort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && temp < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    // Temp variable is used to store the original arr[i] value as the inner while loop changes it.
    // Outside the while loop, j+1 index is used to bring j = -1 back to j = 0.
}
