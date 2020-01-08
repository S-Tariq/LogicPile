package datastructures;

class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class IntLinkedList {
    private Node root;
    private int size = 0;

    public void add(int value) {
        size++;
        if(root == null) {
            root = new Node(value);
            return;
        }
        Node current = root;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        Node node = new Node(value);
        current.setNext(node);
    }

    public void add(int... values) {
        for(int i : values){
            add(i);
        }
    }

    public int get(int index) {
        int i = 0;
        Node current = root;
        while(current.getNext() != null && i < index) {
            current = current.getNext();
            i++;
        }
        if(i == index) {
            return current.getValue();
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void set(int index, int value) {
        int i = 0;
        Node current = root;
        while(current.getNext() != null && i < index) {
            current = current.getNext();
            i++;
        }
        if(i == index) {
            current.setValue(value);
        }
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = root;
        int i = 0;
        while(i < index - 1) {
            current = current.getNext();
            i++;
        }
        if(i != size - 1) {
            current.setNext(current.getNext().getNext());
        } else {
            current.setNext(null);
        }
        size--;


        // Works but there is a node left floating.
//        Node current = root;
//        int i = 0;
//        while(i < index) {
//            current = current.getNext();
//            i++;
//        }
//        while(index < size) {
//            current.setValue(current.getNext().getValue());
//            current = current.getNext();
//            index++;
//        }
//        size--;
    }

    public int indexOf(int value) {
        int count = 0;
        Node current = root;
        while(current.getNext() != null){
            if(current.getValue() == value) {
                return count;
            }
            current = current.getNext();
            count++;
        }
        return -1;
    }

    public boolean contains(int value) {
        Node current = root;
        boolean result = false;
        while(current.getNext() != null) {
            if(current.getValue() == value) {
                result = true;
                break;
            }
            current = current.getNext();
        }
        return result;
    }


    public int size() {
        return this.size;
    }
}
