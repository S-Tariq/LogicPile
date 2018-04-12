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
            while(newData.next != null){
                newData = newData.next;
            }
            newData.next = node;
        }
    }

    public void show(){

        Node node = head;

        while(node.next != null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}
