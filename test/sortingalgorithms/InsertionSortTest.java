package sortingalgorithms;

public class InsertionSortTest {

    public static void main(String[] args) {

        printList(new int[]{4,3,2,1});
        System.out.println();
        printList(new int[]{4,4,2,7,9,1,3,9,10});

    }

    public static void printList(int[] arr) {
        InsertionSort is = new InsertionSort();
        for(int i : is.insertion(arr)) {
            System.out.print(i + " ");
        }
    }
}
