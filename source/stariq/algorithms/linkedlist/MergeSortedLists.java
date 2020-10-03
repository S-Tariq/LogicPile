package stariq.algorithms.linkedlist;

import stariq.datastructures.SinglyLinkedList;

// Merge two sorted linkedlists into one sorted linkedlist.
public class MergeSortedLists {

    public static void main(String[] args) {

        SinglyLinkedList first = new SinglyLinkedList(1);
        SinglyLinkedList head1 = first;
        first.next = new SinglyLinkedList(3);
        first = first.next;
        first.next = new SinglyLinkedList(6);
        first = first.next;
        first.next = new SinglyLinkedList(7);
        first = first.next;
        first.next = new SinglyLinkedList(9);

        SinglyLinkedList second = new SinglyLinkedList(0);
        SinglyLinkedList head2 = second;
        second.next = new SinglyLinkedList(2);
        second = second.next;
        second.next = new SinglyLinkedList(4);
        second = second.next;
        second.next = new SinglyLinkedList(5);
        second = second.next;
        second.next = new SinglyLinkedList(8);
        second = second.next;
        second.next = new SinglyLinkedList(10);

        SinglyLinkedList.printList(head1);
        SinglyLinkedList.printList(head2);
        SinglyLinkedList.printList(merge(head1,head2));

    }

    public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {

        SinglyLinkedList current = new SinglyLinkedList();

        if(list1.data < list2.data) {
            current.data = list1.data;
            list1 = list1.next;
        } else {
            current.data = list2.data;
            list2 = list2.next;
        }

        SinglyLinkedList head = current;

        while(list1 != null && list2 != null) {
            if(list1.data < list2.data) {
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

