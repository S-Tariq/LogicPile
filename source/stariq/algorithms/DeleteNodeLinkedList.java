package stariq.algorithms;

import stariq.datastructures.SinglyLinkedList;

// Delete node at a specific position from linkedlist.
public class DeleteNodeLinkedList {

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
        deleteNode(head, 1);
        SinglyLinkedList.printList(head);
        SinglyLinkedList.printList(deleteNode(head, 0));


    }

    public static SinglyLinkedList deleteNode(SinglyLinkedList head, int position) {
        if(position == 0) {
            return head.next;
        }
        SinglyLinkedList current = head;
        int count = 0;
        while(count < position - 1) {
            current = current.next;
            count++;
        }
        current.next = current.next.next;
        return head;
    }
}
