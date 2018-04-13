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
            Node value = head;
            while(value.next != null){
                value = value.next;
            }
            value.next = node;
        }
    }

    public void insertAtStart(int data){

        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void insertAt(int index, int data){

        Node node = new Node();
        node.data = data;
        node.next = null;

        Node value = head;
        for(int i = 0; i < index; i++){
            value = value.next;
        }
        node.next = value.next;
        value.next = node;
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
