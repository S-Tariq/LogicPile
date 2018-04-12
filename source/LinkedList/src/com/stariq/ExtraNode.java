package com.stariq;

public class ExtraNode {

    ExtraNode next;
    int data;

    public ExtraNode(int data){
        this.data = data;
    }
}

class LinkedList{

    ExtraNode head;

    public void append(int data){

        if(head == null){
            head = new ExtraNode(data);
            return;
        }
        ExtraNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new ExtraNode(data);
    }

    public void prepend(int data){

        ExtraNode newHead = new ExtraNode(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data){
        if(head == null){
            return;
        }

        if(head.data == data){
            head = head.next;
            return;
        }

        ExtraNode current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
