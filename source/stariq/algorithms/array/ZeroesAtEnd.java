package stariq.algorithms.array;

// https://leetcode.com/problems/move-zeroes/
public class ZeroesAtEnd {

    public static void main(String[] args) {
        int[] arr = new int[] {1,4,0,7,0,6,0,2,0,1};
       // arr = new int[] {0, 1, 0, 3, 12, 0};
        zeroesAtEnd(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void zeroesAtEnd(int[] arr) {
        // j index keeps track of 0.
        int j = 0;
        for(int i = 0; i < arr.length ; i++) {
            if(arr[i] != 0) {
                if(i != j) {
                    arr[j] = arr[i];
                    arr[i] = 0;
                }
                j++;
            }
        }
    }

    // Order does not matter as long as all zeroes are at the end.
    public static void zeroesAtEndNoOrder(int[] arr) {
        int j = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == 0) {
                arr[i] = arr[j];
                arr[j] = 0;
                j--;
            }
        }
    }
}
