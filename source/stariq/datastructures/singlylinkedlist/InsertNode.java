package stariq.datastructures.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

// Insert node at a specific position in linkedlist.
public class InsertNode {

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
        ListNode.printList(insertNode(head, 2, 4));
    }

    public static ListNode insertNode(ListNode head, int position, int value) {
        ListNode listNode = new ListNode(value);
        if(position == 0) {
            listNode.next = head;
            head = listNode;
            return head;
        }

        ListNode current = head;
        for(int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        listNode.next = current.next;
        current.next = listNode;

        return head;
    }
}
