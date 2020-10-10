package stariq.algorithms.linkedlist;

import stariq.datastructures.linkedlist.ListNode;

// Find cycle in a linkedlist.
public class FindCycle {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(6);
        list = list.next;
        list.next = new ListNode(7);
        System.out.println(foundCycle(head));
        list = list.next;
        list.next = head.next;
        System.out.println(foundCycle(head));

        //SinglyLinkedList.printList(head);
        // Do not print the list as there is a loop which runs out java memory.
    }

    public static boolean foundCycle(ListNode head) {

        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

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
