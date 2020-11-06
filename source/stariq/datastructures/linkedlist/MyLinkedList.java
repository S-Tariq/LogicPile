package stariq.datastructures.linkedlist;

import stariq.datastructures.nodes.ListNode;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);
    }

    ListNode head;
    int size = 0;

    public MyLinkedList() {
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head;
        head = listNode;
        size++;
    }

    public void addAtTail(int val) {
        if(head == null) {
            head = new ListNode(val);
        }
        ListNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index >= size) {
            return;
        }
        ListNode current = head;
        for(int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        ListNode listNode = new ListNode(val);
        listNode.next = current.next;
        current.next = listNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index > size - 1) {
            return;
        }
        if(index == 0) {
            head = head.next;
            return;
        }
        ListNode current = head;
        for(int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

}
