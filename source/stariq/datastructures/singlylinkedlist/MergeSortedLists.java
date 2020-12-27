package stariq.datastructures.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

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

//        ListNode.printList(head1);
//        ListNode.printList(head2);
//        ListNode.printList(mergeSorted2(head1,head2));

        ListNode.printList(head1);
        ListNode.printList(head2);
        ListNode.printList(mergeList(head1,head2));

    }

    public static ListNode mergeList(ListNode list1, ListNode list2) {

        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode merged = new ListNode(0);
        ListNode head = merged;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                merged.next = list1;
                list1 = list1.next;
            } else {
                merged.next = list2;
                list2 = list2.next;
            }
            merged = merged.next;
        }

        if(list1 != null) {
            merged.next = list1;
        }
        if(list2 != null) {
            merged.next = list2;
        }

        return head.next;
    }

    public static ListNode mergeSorted2(ListNode list1, ListNode list2) {

        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode merged = new ListNode();

        if(list1.val < list2.val) {
            merged.val = list1.val;
            list1 = list1.next;
        } else {
            merged.val = list2.val;
            list2 = list2.next;
        }

        ListNode head = merged;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                merged.next = list1;
                list1 = list1.next;
            } else {
                merged.next = list2;
                list2 = list2.next;
            }
            merged = merged.next;
        }

        // Run while loops until both lists are pointing to null
//        while(list1 != null) {
//            merged.next = list1;
//            list1 = list1.next;
//            merged = merged.next;
//        }
//
//        while(list2 != null) {
//            merged.next = list2;
//            list2 = list2.next;
//            merged = merged.next;
//        }

        // Assign remaining list values to merged - Better way than running unnecessary loops.
        if(list1 != null) {
            merged.next = list1;
        }
        if(list2 != null) {
            merged.next = list2;
        }

        return head;
    }

}

