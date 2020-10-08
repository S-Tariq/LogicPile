package stariq.algorithms.linkedlist;

import stariq.datastructures.linkedlist.SinglyLinkedList;

// Reverse the elements of a linkedlist.
public class Reverse {

    public static void main(String[] args) {

        // Input: 1,2,3,4
        // Output: 4,3,2,1
        // If input size 1 or less, return original list.

        SinglyLinkedList node = new SinglyLinkedList(1);
        SinglyLinkedList head = node;
        node.next = new SinglyLinkedList(2);
        node = node.next;
        node.next = new SinglyLinkedList(3);
        node = node.next;
        node.next = new SinglyLinkedList(4);
        SinglyLinkedList.printList(head);
        reverse(head);
        SinglyLinkedList.printList(reverse(head));
        SinglyLinkedList.printList(reverse2(head));

    }

    public static SinglyLinkedList reverse(SinglyLinkedList list) {
        SinglyLinkedList reverse = new SinglyLinkedList(list.data);
        SinglyLinkedList current = list.next;
        while(current != null) {
            SinglyLinkedList prepend = new SinglyLinkedList(current.data);
            prepend.next = reverse;
            reverse = prepend;
            current = current.next;
        }
        return reverse;
    }

    public static SinglyLinkedList reverse2(SinglyLinkedList list) {
        SinglyLinkedList reverse = null;
        SinglyLinkedList current = list;
        while(current != null) {
            SinglyLinkedList prepend = new SinglyLinkedList(current.data);
            prepend.next = reverse;
            reverse = prepend;
            current = current.next;
        }
        return reverse;
    }

}




