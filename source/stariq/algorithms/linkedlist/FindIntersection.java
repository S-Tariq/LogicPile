package stariq.algorithms.linkedlist;

import stariq.datastructures.linkedlist.SinglyLinkedList;

// Find intersection of two linkedlists.
public class FindIntersection {

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList(1);
        SinglyLinkedList head1 = list1;
        list1.next = new SinglyLinkedList(3);
        list1 = list1.next;
        list1.next = new SinglyLinkedList(6);
        list1 = list1.next;

        SinglyLinkedList list2 = new SinglyLinkedList(8);
        SinglyLinkedList head2 = list2;
        list2.next = new SinglyLinkedList(5);
        list2 = list2.next;

        list1.next = new SinglyLinkedList(7);
        list2.next = list1.next; // list2 intersects list1
        list1 = list1.next;
        list1.next = new SinglyLinkedList(9);

        SinglyLinkedList.printList(head1);
        SinglyLinkedList.printList(head2);

        SinglyLinkedList.printList(intersectionNode(head1, head2));
    }

    public static SinglyLinkedList intersectionNode(SinglyLinkedList head1, SinglyLinkedList head2) {
        SinglyLinkedList point1 = head1;
        SinglyLinkedList point2 = head2;

        while(point1 != point2) {
            if(point1 == null) {
                point1 = head2;
            } else {
                point1 = point1.next;
            }

            if(point2 == null) {
                point2 = head1;
            } else {
                point2 = point2.next;
            }
        }
        return point1;
    }
}
