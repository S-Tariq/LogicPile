package stariq.datastructures;

public class CharLinkedList {

    class Node {
        private char value;
        private Node next;

        Node(char value) {
            this.value = value;
        }

        public char getValue() {
            return this.value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private int size = 0;
    private Node root;

    public void add(char value) {
        size++;
        if(root == null) {
            root = new Node(value);
            return;
        }
        Node current = root;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node(value));
}

    public void add(char... values) {
        for(char c : values) {
            add(c);
        }
    }

    public char get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = root;
        int count = 0;
        while(count < index) {
            current = current.getNext();
            count++;
        }
        return current.getValue();
    }

    public void set(int index, char value) {
        Node current = root;
        int count = 0;
        while(count < index) {
            current = current.getNext();
            count++;
        }
        if(count == index) {
            current.setValue(value);
        }
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = root;
        int count = 0;
        while(count < index - 1) {
            current = current.getNext();
            count++;
        }
        if(count != size - 1) {
            current.setNext(current.getNext().getNext());
        } else {
            current.setNext(null);
        }
        size--;
    }

    public int indexOf(char value) {
        Node current = root;
        int count = 0;
        while(current.getNext() != null) {
            if(current.getValue() == value) {
                return count;
            }
            current = current.getNext();
            count++;
        }
        return -1;
    }

    public boolean contains(char value) {
        Node current = root;
        while(current != null) {
            if(current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int size() {
        return this.size;
    }
}
