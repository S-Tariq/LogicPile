package stariq.datastructures.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);

        ListNode.printList(deleteDuplicates(node));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode current = head;
        while(current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current != null) {
            if(previous != null && previous.val == current.val) {
                previous.next = current.next;
            } else {
                previous = current;

            }
            current = current.next;

        }
        return head;
    }
}
