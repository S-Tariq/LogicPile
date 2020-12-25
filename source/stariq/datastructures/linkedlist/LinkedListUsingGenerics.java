package stariq.datastructures.linkedlist;

public class LinkedListUsingGenerics<E> {

    public static void main(String[] args) {
        LinkedListUsingGenerics<Integer> list = new LinkedListUsingGenerics<>();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(2,0);
        list.removeAtIndex(1);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(0));
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);
    }

    class Node<T> {
        T val;
        Node<T> next;

        Node(T val) {
            this.val = val;
        }
    }

    private Node<E> head;
    private int size;

    public void addAtHead(E val) {
        Node<E> node = new Node<>(val);
        node.next = head;
        head = node;
        size++;
    }

    public void addAtTail(E val) {
        Node<E> node = new Node<>(val);
        if(head == null) {
            head = node;
            return;
        }
        Node<E> current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = node;
        size++;
    }

    public void addAtTail(E... values) {
        for(E e : values) {
            addAtTail(e);
        }
    }

    public void addAtIndex(int index, E val) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> current = head;
        for(int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<E> node = new Node<>(val);
        node.next = current.next;
        current.next = node;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void set(int index, E val) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        current.val = val;
    }

    public void removeAtIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(index == 0) {
            head = head.next;
            return;
        }
        Node<E> current = head;
        for(int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public int indexOf(E val) {
        Node<E> current = head;
        int index = 0;
        while(current != null) {
            if(current.val == val) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(E val) {
        Node<E> current = head;
        while(current != null) {
            if(current.val == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

}
