package com.stariq;

public class Main {

    public static void main(String[] args) {

    CustomLinkedList list = new CustomLinkedList();
    list.insert(2);
    list.insert(5);
    list.insert(7);
    list.insertAtStart(4);
    list.insertAt(2,8);
    list.show();

    }
}
