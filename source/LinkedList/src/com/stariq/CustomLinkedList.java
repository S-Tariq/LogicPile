package com.stariq;

public class CustomLinkedList {

    Node head;

    public void insert(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head == null){
            head = node;
        } else {
            Node newData = head;
        }
    }
}
