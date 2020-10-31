package stariq.datastructures.linkedlist;

class IntNode {
    private int value;
    private IntNode next;

    public IntNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public IntNode getNext() {
        return this.next;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }
}

public class IntLinkedList {
    private IntNode root;
    private int size = 0;

    public void add(int value) {
        size++;
        if(root == null) {
            root = new IntNode(value);
            return;
        }
        IntNode current = root;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        IntNode intNode = new IntNode(value);
        current.setNext(intNode);
    }

    public void add(int... values) {
        for(int i : values){
            add(i);
        }
    }

    public int get(int index) {
        int i = 0;
        IntNode current = root;
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
        IntNode current = root;
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
        IntNode current = root;
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
        IntNode current = root;
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
        IntNode current = root;
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
