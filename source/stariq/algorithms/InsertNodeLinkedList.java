package stariq.algorithms;

import stariq.datastructures.SinglyLinkedList;

// Insert node at a specific position to linkedlist.
public class InsertNodeLinkedList {

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
        SinglyLinkedList.printList(insertNode(head, 2, 4));
    }

    public static SinglyLinkedList insertNode(SinglyLinkedList head, int position, int data) {
        SinglyLinkedList node = new SinglyLinkedList(data);
        if(position == 0) {
            node.next = head;
            head = node;
            return head;
        }
        SinglyLinkedList current = head;
        int count = 0;
        while(count < position - 1) {
            current = current.next;
            count++;
        }
        SinglyLinkedList temp = current.next;
        current.next = node;
        node.next = temp;
        return head;
    }
}
