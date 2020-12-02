package stariq.algorithms.array;

// Rotation from left to right
// Number of rotation in array (by 1 element counts as 1 rotation).
public class RotationInSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[] {15, 18, 2, 3, 6, 12};
        System.out.println(rotation(arr));

        arr = new int[] {7, 9, 11, 12, 5};
        System.out.println(rotation(arr));

        arr = new int[] {7, 9, 11, 12, 15};
        System.out.println(rotation(arr));
    }

    public static int rotation(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                count = i + 1;
                break;
            }
        }
        return count;
    }
}
