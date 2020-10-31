package stariq.algorithms.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

// Reverse the elements of a linkedlist.
public class Reverse {

    public static void main(String[] args) {

        // Input: 1,2,3,4
        // Output: 4,3,2,1
        // If input size 1 or less, return original list.

        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        ListNode.printList(head);
        reverse(head);
        ListNode.printList(reverse(head));
        ListNode.printList(reverse2(head));

    }

    public static ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode reverse = new ListNode(head.val);
        ListNode current = head.next;
        while(current != null) {
            ListNode prepend = new ListNode(current.val);
            prepend.next = reverse;
            reverse = prepend;
            current = current.next;
        }
        return reverse;
    }

    public static ListNode reverse2(ListNode head) {
        ListNode reverse = null;
        ListNode current = head;
        while(current != null) {
            ListNode prepend = new ListNode(current.val);
            prepend.next = reverse;
            reverse = prepend;
            current = current.next;
        }
        return reverse;
    }

}




