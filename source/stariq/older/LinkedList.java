package stariq.older;

public class LinkedList {

    class LinkedNode {

        LinkedNode next;
        int data;
    }

    LinkedNode head;

    public void insert(int data){

        LinkedNode node = new LinkedNode();
        node.data = data;
        node.next = null;

        if(head == null){
            head = node;
        } else {
            LinkedNode value = head;
            while(value.next != null){
                value = value.next;
            }
            value.next = node;
        }
    }

    public void insertAtStart(int data){

        LinkedNode node = new LinkedNode();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
        //System.out.println("Inserted at start: " + head.data);
    }

    public void insertAt(int index, int data){

        LinkedNode node = new LinkedNode();
        node.data = data;
        node.next = null;

        if(index == 0){
            insertAtStart(data);
        } else {
            LinkedNode value = head;
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
            LinkedNode value = head;
            LinkedNode anotherValue = null;
            for(int i = 0; i < index - 1; i++){
                value = value.next;
            }
            anotherValue = value.next;
            value.next = anotherValue.next;
            //System.out.println("Deleted: " + anotherValue.data);
        }
    }

    public void show(){

        LinkedNode node = head;

        while(node.next != null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}
