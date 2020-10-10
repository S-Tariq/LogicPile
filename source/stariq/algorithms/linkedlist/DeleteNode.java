package stariq.algorithms.linkedlist;

import stariq.datastructures.linkedlist.ListNode;

// Delete node at a specific position from linkedlist.
public class DeleteNode {

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
        deleteNode(head, 1);
        ListNode.printList(head);
        ListNode.printList(deleteNode(head, 0));


    }

    public static ListNode deleteNode(ListNode head, int position) {
        if(position == 0) {
            return head.next;
        }
        ListNode current = head;
        int count = 0;
        while(count < position - 1) {
            current = current.next;
            count++;
        }
        current.next = current.next.next;
        return head;
    }
}
