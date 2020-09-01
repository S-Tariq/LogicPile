package stariq.datastructures;

class OldLinkedNode {

    OldLinkedNode next;
    int data;
}

public class OldLinkedList {

    OldLinkedNode head;

    public void insert(int data){

        OldLinkedNode node = new OldLinkedNode();
        node.data = data;
        node.next = null;

        if(head == null){
            head = node;
        } else {
            OldLinkedNode value = head;
            while(value.next != null){
                value = value.next;
            }
            value.next = node;
        }
    }

    public void insertAtStart(int data){

        OldLinkedNode node = new OldLinkedNode();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
        //System.out.println("Inserted at start: " + head.data);
    }

    public void insertAt(int index, int data){

        OldLinkedNode node = new OldLinkedNode();
        node.data = data;
        node.next = null;

        if(index == 0){
            insertAtStart(data);
        } else {
            OldLinkedNode value = head;
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
            OldLinkedNode value = head;
            OldLinkedNode anotherValue = null;
            for(int i = 0; i < index - 1; i++){
                value = value.next;
            }
            anotherValue = value.next;
            value.next = anotherValue.next;
            //System.out.println("Deleted: " + anotherValue.data);
        }
    }

    public void show(){

        OldLinkedNode node = head;

        while(node.next != null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}
