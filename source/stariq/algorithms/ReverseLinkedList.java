package stariq.algorithms;

import stariq.datastructures.SinglyLinkedList;

public class ReverseLinkedList {

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
        printList(head);

        printList(reverse(head));
        printList(reverse2(head));

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

    public static void printList(SinglyLinkedList list) {
        StringBuilder elements = new StringBuilder();
        while(list != null) {
            elements.append(list.data);
            elements.append(" ");
            list = list.next;
        }
        System.out.println(elements.toString());
    }

}




