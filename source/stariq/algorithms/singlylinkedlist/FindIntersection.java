package stariq.algorithms.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

// Find the node where intersection begins of two linkedlists.
// Find intersection of two linkedlists.
public class FindIntersection {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode head1 = list1;
        list1.next = new ListNode(3);
        list1 = list1.next;
        list1.next = new ListNode(6);
        list1 = list1.next;

        ListNode list2 = new ListNode(8);
        ListNode head2 = list2;
        list2.next = new ListNode(5);
        list2 = list2.next;

        list1.next = new ListNode(7);
        list2.next = list1.next; // list2 intersects list1
        list1 = list1.next;
        list1.next = new ListNode(9);

        ListNode.printList(head1);
        ListNode.printList(head2);

        ListNode.printList(intersectionNode(head1, head2));
        System.out.println(foundIntersection(head1, head2));
    }

    public static ListNode intersectionNode(ListNode head1, ListNode head2) {
        ListNode current1 = head1;
        ListNode current2 = head2;

        while(current1 != current2) {
            if(current1 == null) {
                current1 = head2;
            } else {
                current1 = current1.next;
            }

            if(current2 == null) {
                current2 = head1;
            } else {
                current2 = current2.next;
            }
        }
        return current1;
    }

    public static boolean foundIntersection(ListNode head1, ListNode head2) {
        ListNode current1 = head1;
        ListNode current2 = head2;

        while(current1.next != null) {
            current1 = current1.next;
        }

        while(current2 != null) {
            if(current1 == current2) {
                return true;
            }
            current2 = current2.next;
        }
        return false;
    }
}
