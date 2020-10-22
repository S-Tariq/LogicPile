package stariq.algorithms.linkedlist;

import stariq.datastructures.linkedlist.ListNode;
 // Remove specific elements from the linkedlist.
public class RemoveElements {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(6);
        list = list.next;
        list.next = new ListNode(7);
        list = list.next;
        list.next = new ListNode(9);
        list = list.next;
        list.next = new ListNode(6);
        ListNode.printList(head);
        ListNode.printList(removeElements(head, 6));
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode previous = dummy;
        while(current != null) {
            if(current.val == val) {
                previous.next = current.next;
            } else {
                previous = previous.next;
            }
            current = current.next;
        }
        return dummy.next;
        // Return dummy.next instead of head as head can become null if head.val == val.
    }
}
