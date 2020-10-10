package stariq.datastructures.linkedlist;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public static void printList(ListNode list) {
        StringBuilder elements = new StringBuilder();
        while(list != null) {
            elements.append(list.val);
            elements.append(" ");
            list = list.next;
        }
        System.out.println(elements.toString());
    }
}
