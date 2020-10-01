package stariq.datastructures;

public class SinglyLinkedList {

    public int data;
    public SinglyLinkedList next;

    public SinglyLinkedList() {

    }

    public SinglyLinkedList(int data) {
        this.data = data;
    }

    public static void printList(SinglyLinkedList list) {
        StringBuilder elements = new StringBuilder();
        while(list != null) {
            elements.append(list.data);
            elements.append(" ");
            list = list.next;
        }
        System.out.println(elements.toString());
    }
}
