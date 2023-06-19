package stariq.datastructures;

import stariq.datastructures.linkedlist.LinkedListUsingGenerics;

public class LinkedListUsingGenericsTest {
    public static void main(String[] args) {
        LinkedListUsingGenerics<Integer> list = new LinkedListUsingGenerics<>();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(2,0);
        list.removeAtIndex(1);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(0));
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);
    }
}
