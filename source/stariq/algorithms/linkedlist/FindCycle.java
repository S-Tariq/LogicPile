package stariq.algorithms.linkedlist;

import stariq.datastructures.linkedlist.ListNode;

import java.util.HashSet;

// Find cycle in a linkedlist.
// Find the node where the cycle begins in a linkedlist.
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
        // Do not print the list as there is a loop which runs out java memory.

        ListNode.printList(cycleNode(head));
    }

    public static boolean foundCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean foundCycle2(ListNode head) {
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

    // Space complexity O(1)
    public static ListNode cycleNode(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                ListNode slow2 = head;
                while(slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return new ListNode(slow.val);
            }
        }
        return null;
    }

    // Space complexity O(n)
    public static ListNode cycleNode2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode current = head;
        while(current != null) {
            if(set.contains(current)) {
                return new ListNode(current.val);
            } else {
                set.add(current);
            }
            current = current.next;
        }
        return null;
    }
}
