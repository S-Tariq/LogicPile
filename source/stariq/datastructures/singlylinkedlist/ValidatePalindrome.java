package stariq.datastructures.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-linked-list/
public class ValidatePalindrome {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
    }

    // Space complexity = O(n)
    public static boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while(current != null) {
            list.add(current);
            current = current.next;
        }
        for(int i = 0; i < list.size()/2; i++) {
            if(list.get(i).val != list.get(list.size() - 1 - i).val) {
                return false;
            }
        }
        return true;
    }

    // Space complexity = O(n)
    public static boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while(slow != null) {
            if(slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode reverse = new ListNode(head.val);
        ListNode current = head.next;
        while(current != null) {
            ListNode prepend = new ListNode(current.val);
            prepend.next = reverse;
            reverse = prepend;
            current = current.next;
        }
        return reverse;
    }
}
