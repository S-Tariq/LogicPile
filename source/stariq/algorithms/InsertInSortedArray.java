package stariq.algorithms;

// Insert element into a sorted array.
public class InsertInSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,6,7,8,10};
        for(int i : insert(arr,11)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : insert(arr,9)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : insert(arr,0)) {
            System.out.print(i + " ");
        }
    }

    public static int[] insert(int[] arr, int val) {
        int[] newArr = new int[arr.length + 1];
        int i = 0;
        int k = 0;
        while(i < arr.length && val > arr[i]) {
            newArr[k++] = arr[i++];
        }
        newArr[k++] = val;
        while(i < arr.length && val < arr[i]) {
            newArr[k++] = arr[i++];
        }
        return newArr;
    }

//    public static int[] insertElement(int[] arr, int val) {
//        int[] newArr = new int[arr.length + 1];
//        int i = 0;
//        for(;i < newArr.length - 1; i++) {
//            if(arr[i] < val) {
//                newArr[i] = arr[i];
//            } else {
//                newArr[i] = val;
//                break;
//            }
//        }
//        if(i < arr.length) {
//            for(; i < arr.length; i++) {
//                newArr[i + 1] = arr[i];
//            }
//        } else {
//            newArr[i] = val;
//        }
//        return newArr;
//    }
}
