package stariq.datastructures.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {

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
        ListNode.printList(removeNthFromEnd(head, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
