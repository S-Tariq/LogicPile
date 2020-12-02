package stariq.algorithms.array;

public class ZeroesAtStart {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,0,6,0,0,0,1};
        zerosAtStart(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void zerosAtStart(int[] arr) {
        int j = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] != 0) {
                if(i != j) {
                    arr[j] = arr[i];
                    arr[i] = 0;
                }
                j--;
            }
        }
    }

    public static void zerosAtStartNoOrder(int[] arr) {
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                arr[i] = arr[j];
                arr[j] = 0;
                j++;
            }
        }
    }
}

