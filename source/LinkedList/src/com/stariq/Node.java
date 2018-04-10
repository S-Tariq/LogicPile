package com.stariq;

public class Node {

    Node next;
    int data;

    public Node(int data){
        this.data = data;
    }
}

class LinkedList{

    Node head;

    public void append(int data){

        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data){
        
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }
}
