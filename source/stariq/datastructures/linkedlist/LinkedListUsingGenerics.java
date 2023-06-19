package stariq.datastructures.linkedlist;

/*
- Add:
The add() method is O(n) worse-case as it adds a new node to the end of the list.

- Add & Remove at the head or tail:
Adding or removing node at the head or tail is O(1) as it does not require iteration
as long as you store head and tail reference as field.

- Specific-index Add:
Adding at a specific index is O(n) as it needs to iterate through the list to find the index to add the element.

- Remove:
The remove() method is O(n) as it needs to iterate to find the index to remove the element.
The remove() method that takes in the reference of node to remove is O(1).

- Contains & Get % Set:
The contains() method is O(n) as it needs to iterate to find the element.
The get() and set() methods are also O(n) as it requires iteration.
 */

public class LinkedListUsingGenerics<E> {

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
        } else {
            Node<E> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
            size++;
        }
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
            if(current.val.equals(val)) {
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
            if(current.val.equals(val)) {
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
