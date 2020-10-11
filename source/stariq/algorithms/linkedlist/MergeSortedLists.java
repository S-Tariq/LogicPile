package stariq.algorithms.linkedlist;

import stariq.datastructures.linkedlist.ListNode;

// Merge two sorted linkedlists into one sorted linkedlist.
public class MergeSortedLists {

    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        ListNode head1 = first;
        first.next = new ListNode(3);
        first = first.next;
        first.next = new ListNode(6);
        first = first.next;
        first.next = new ListNode(7);
        first = first.next;
        first.next = new ListNode(9);

        ListNode second = new ListNode(0);
        ListNode head2 = second;
        second.next = new ListNode(2);
        second = second.next;
        second.next = new ListNode(4);
        second = second.next;
        second.next = new ListNode(5);
        second = second.next;
        second.next = new ListNode(8);
        second = second.next;
        second.next = new ListNode(10);

        ListNode.printList(head1);
        ListNode.printList(head2);
        ListNode.printList(merge(head1,head2));

    }

    public static ListNode merge(ListNode list1, ListNode list2) {

        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode current = new ListNode();

        if(list1.val < list2.val) {
            current.val = list1.val;
            list1 = list1.next;
        } else {
            current.val = list2.val;
            list2 = list2.next;
        }

        ListNode head = current;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        while(list1 != null) {
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        }

        while(list2 != null) {
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }

        return head;
    }

}

