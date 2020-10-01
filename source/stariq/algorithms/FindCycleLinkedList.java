package stariq.algorithms;

import stariq.datastructures.SinglyLinkedList;

public class FindCycleLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(1);
        SinglyLinkedList head = list;
        list.next = new SinglyLinkedList(3);
        list = list.next;
        list.next = new SinglyLinkedList(6);
        list = list.next;
        list.next = new SinglyLinkedList(7);
        System.out.println(foundCycle(head));
        list = list.next;
        list.next = head.next;
        System.out.println(foundCycle(head));

        //SinglyLinkedList.printList(head);
        // Do not print the list as there is a loop which runs out java memory.
    }

    public static boolean foundCycle(SinglyLinkedList head) {

        if(head == null) {
            return false;
        }

        SinglyLinkedList slow = head;
        SinglyLinkedList fast = head.next;

        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
