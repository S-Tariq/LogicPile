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
        //System.out.println("Inserted at start: " + head.data);
    }

    public void insertAt(int index, int data){

        Node node = new Node();
        node.data = data;
        node.next = null;

        if(index == 0){
            insertAtStart(data);
        } else {
            Node value = head;
            for (int i = 0; i < index - 1; i++) {
                value = value.next;
            }
            node.next = value.next;
            value.next = node;
            //System.out.println("Inserted: " + node.data);
        }
    }

    public void deleteAt(int index){

        if(index == 0){
            head = head.next;
        } else {
            Node value = head;
            Node anotherValue = null;
            for(int i = 0; i < index - 1; i++){
                value = value.next;
            }
            anotherValue = value.next;
            value.next = anotherValue.next;
            //System.out.println("Deleted: " + anotherValue.data);
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
