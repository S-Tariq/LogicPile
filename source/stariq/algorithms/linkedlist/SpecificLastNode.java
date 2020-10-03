package stariq.algorithms.linkedlist;

import stariq.datastructures.SinglyLinkedList;

// Find the specific node from the end of linkedlist.
public class SpecificLastNode {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(1);
        SinglyLinkedList head = list;
        list.next = new SinglyLinkedList(3);
        list = list.next;
        list.next = new SinglyLinkedList(6);
        list = list.next;
        list.next = new SinglyLinkedList(7);
        list = list.next;
        list.next = new SinglyLinkedList(9);
        SinglyLinkedList.printList(head);
        SinglyLinkedList.printList(specificLastNode(head, 4));
    }

    public static SinglyLinkedList specificLastNode(SinglyLinkedList head, int lastPosition) {
        SinglyLinkedList fast = head;
        SinglyLinkedList slow = head;

        for(int i = 0; i < lastPosition; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return new SinglyLinkedList(slow.data);
    }

}
