package sortingalgorithms;

public class SelectionSortTest {

    public static void main(String[] args) {

        printList(new int[] {4,7,8,2,4,1});

    }

    public static void printList(int[] arr) {
        for(int i : SelectionSort.selection(arr)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
