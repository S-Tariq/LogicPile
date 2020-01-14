package sortingalgorithms;

public class BubbleSortTest {

    public static void main(String[] args) {

        printList1(new int[]{4,3,2,1});
        printList2(new int[]{4,3,2,1});
        printList1(new int[]{4,4,2,7,9,1,3,9,10});
        printList2(new int[]{4,4,2,7,9,1,3,9,10});

    }

    public static void printList1(int[] arr) {
        for(int i : BubbleSort.bubble1(arr)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printList2(int[] arr) {
        for(int i : BubbleSort.bubble2(arr)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
