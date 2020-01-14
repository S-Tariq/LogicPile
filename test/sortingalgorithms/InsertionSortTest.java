package sortingalgorithms;

public class InsertionSortTest {

    public static void main(String[] args) {

        printList(new int[]{4,3,2,1});
        printList(new int[]{4,4,2,7,9,1,3,9,10});

    }

    public static void printList(int[] arr) {
        for(int i : InsertionSort.insertion(arr)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
