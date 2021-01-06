package stariq.datastructures.singlylinkedlist;

import stariq.datastructures.nodes.ListNode;

public class DeleteNLastNodes {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(6);
        list = list.next;
        ListNode del = list;
        list.next = new ListNode(7);
        list = list.next;
        list.next = new ListNode(9);
        ListNode.printList(deleteNodes(head, 2));

    }

    public static ListNode deleteNodes(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

}
