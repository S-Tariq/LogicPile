package stariq.algorithms.linkedlist;

import stariq.datastructures.linkedlist.ListNode;

// Add two numbers from two linkedlist and return the sum as a linkedlist.
// The elements are stored in reverse order (if it isnt then it needs to be reversed).
// Each node contains a single digit.
// L1 = 2, 4, 3
// L2 = 5, 6, 4
// Sum = 7, 0, 8
// Actual equation: 342 + 465 = 807
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        ListNode.printList(addNumbers(list1,list2));
    }

    public static ListNode addNumbers(ListNode head1, ListNode head2) {
        ListNode current1 = head1;
        ListNode current2 = head2;
        ListNode result = new ListNode(-1);
        ListNode head = result;

        int carry = 0;
        while(current1 != null && current2 != null) {
            int sum = current1.val + current2.val + carry;
            if(sum < 10) {
                result.next = new ListNode(sum);
                carry = 0;
            } else {
                result.next = new ListNode(sum % 10);
                carry = sum / 10;
            }
            result = result.next;
            current1 = current1.next;
            current2 = current2.next;
        }

        while(current1 != null) {
            int sum = current1.val + carry;
            if(sum < 10) {
                result.next = new ListNode(sum);
                carry = 0;
            } else {
                result.next = new ListNode(sum % 10);
                carry = sum / 10;
            }
            result = result.next;
            current1 = current1.next;
        }

        while(current2 != null) {
            int sum = current2.val + carry;
            if(sum < 10) {
                result.next = new ListNode(sum);
                carry = 0;
            } else {
                result.next = new ListNode(sum % 10);
                carry = sum / 10;
            }
            result = result.next;
            current2 = current2.next;
        }

        if(carry > 0) {
            result.next = new ListNode(carry);
        }

        return head.next;
    }
}
