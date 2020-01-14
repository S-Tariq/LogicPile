package sortingalgorithms;

public class QuickSortTest {

    public static void main(String[] args) {

        printList(new int[] {8,1,3,7,9,2,5});
        printList(new int[] {3,7,6,1,9,7,5,5,2,1,0});

    }


    public static void printList(int[] arr) {
        for(int i : QuickSort.quick(arr, 0, arr.length - 1)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }



}
