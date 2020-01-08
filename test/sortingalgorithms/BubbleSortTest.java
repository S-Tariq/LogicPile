package sortingalgorithms;

public class BubbleSortTest {

    public static void main(String[] args) {

        printList1(new int[]{4,3,2,1});
        System.out.println();
        printList2(new int[]{4,3,2,1});

        System.out.println();

        printList1(new int[]{4,4,2,7,9,1,3,9,10});
        System.out.println();
        printList2(new int[]{4,4,2,7,9,1,3,9,10});

    }

    public static void printList1(int[] arr) {
        BubbleSort bs = new BubbleSort();
        for(int i : bs.bubble1(arr)) {
            System.out.print(i + " ");
        }
    }

    public static void printList2(int[] arr) {
        BubbleSort bs = new BubbleSort();
        for(int i : bs.bubble2(arr)) {
            System.out.print(i + " ");
        }
    }

}
