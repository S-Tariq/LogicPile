package stariq.datastructures;

import stariq.datastructures.linkedlist.OldLinkedList;

public class OldLinkedListTest {

    public static void main(String[] args) {

    OldLinkedList list = new OldLinkedList();
    list.insert(2);
    list.insert(5);
    list.insert(7);
    list.insertAtStart(4);
    list.insertAt(4,8);
    list.deleteAt(2);
    list.show();

    }
}
