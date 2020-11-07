package stariq.algorithms.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/add-two-numbers-ii/
// Same as AddTwoNumbers except the order is not in reverse (it needs to be reversed).
// L1 = 7, 2, 4, 3
// L2 =    5, 6, 4
// Sum = 7, 8, 0, 7
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(7);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        list1.next.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        ListNode.printList(addTwoNumbers(list1, list2));
    }

    // Using stack to reverse two input lists and prepend to reverse output list.
    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(list1 != null) {
            stack1.push(list1.val);
            list1 = list1.next;
        }

        while(list2 != null) {
            stack2.push(list2.val);
            list2 = list2.next;
        }

        ListNode result = null;
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = (!stack1.isEmpty() ? stack1.pop() : 0) + (!stack2.isEmpty() ? stack2.pop() : 0) + carry;

            ListNode prepend = new ListNode(sum % 10);
            prepend.next = result;
            result = prepend;

            carry = sum / 10;
        }
        return result;
    }

    // Using while loop to reverse two input lists and output list.
    public static ListNode addTwoNumbers2(ListNode list1, ListNode list2) {
        ListNode reverse1 = new ListNode(list1.val);
        while(list1.next != null) {
            ListNode prepend = new ListNode(list1.next.val);
            prepend.next = reverse1;
            reverse1 = prepend;
            list1 = list1.next;
        }
        ListNode reverse2 = new ListNode(list2.val);
        while(list2.next != null) {
            ListNode prepend = new ListNode(list2.next.val);
            prepend.next = reverse2;
            reverse2 = prepend;
            list2 = list2.next;
        }
        ListNode reverseResult = new ListNode(0);
        ListNode reverseHead = reverseResult;
        int carry = 0;
        while(reverse1 != null || reverse2 != null || carry > 0) {
            int sum = (reverse1 != null ? reverse1.val : 0) + (reverse2 != null ? reverse2.val : 0) + carry;
            reverseResult.next = new ListNode(sum % 10);
            carry = sum / 10;

            reverse1 = reverse1 != null ? reverse1.next : reverse1;
            reverse2 = reverse2 != null ? reverse2.next : reverse2;
            reverseResult = reverseResult.next;
        }
        ListNode result = new ListNode(reverseHead.next.val);
        reverseHead = reverseHead.next;
        ListNode head = result;
        while(reverseHead.next != null) {
            ListNode prepend = new ListNode(reverseHead.next.val);
            prepend.next = result;
            result = prepend;
            reverseHead = reverseHead.next;
        }
        return result;
    }
}
