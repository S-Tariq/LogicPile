package stariq.datastructures.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

// Find the specific node from the end of linkedlist.
public class FindNthNodeFromEnd {

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
        ListNode.printList(head);
        ListNode.printList(nthLastNode(head, 2));
    }

    public static ListNode nthLastNode(ListNode head, int lastPosition) {
        if(head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0; i < lastPosition; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
