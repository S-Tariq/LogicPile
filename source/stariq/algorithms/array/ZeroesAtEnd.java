package stariq.algorithms.array;

public class ZeroesAtEnd {

    public static void main(String[] args) {
        int[] arr = new int[] {1,4,0,7,0,6,0,2,0,1};
        zerosAtEnd(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void zerosAtEnd(int[] arr) {
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
