package stariq.datastructures.queue;

// https://www.tutorialcup.com/interview/linked-list/implementation-of-deque-using-doubly-linked-list.htm
public class DequeUsingNode {

    public static void main(String[] args) {
        DequeUsingNode queue = new DequeUsingNode();
        queue.addFirst(3);
        queue.addFirst(2);
        queue.addLast(4);
        queue.addLast(6);
        queue.addFirst(1);

        queue.print();

        System.out.println();
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeLast());
        System.out.println(queue.removeLast());

        System.out.println("Front element: " + queue.peekFirst());
        System.out.println("Back element: " + queue.peekLast());
        System.out.println("Queue size: " + queue.size());
        queue.print();
    }

    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node front;
    Node back;
    int size;

    DequeUsingNode() {

    }

    public void addFirst(int element) {
        Node node = new Node(element);
        // First node to be added.
        if(front == null) {
            front = node;
            back = node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
        size++;
    }

    public void addLast(int element) {
        Node node = new Node(element);
        // First node to be added.
        if(back == null) {
            back = node;
            front = node;
        } else {
            back.next = node;
            node.prev = back;
            back = node;
        }
        size++;
    }

    public int removeFirst() {
        if(front == null) {
            throw new NullPointerException();
        }
        int removed = front.val;
        // One node present.
        if(front == back) {
            front = null;
            back = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return removed;
    }

    public int removeLast() {
        if(back == null) {
            throw new NullPointerException();
        }
        int removed = back.val;
        // One node present.
        if(back == front) {
            back = null;
            front = null;
        } else {
            back = back.prev;
            back.next = null;
        }
        size--;
        return removed;
    }

    public int peekFirst() {
        if(front == null) {
            throw new NullPointerException();
        }
        return front.val;
    }

    public int peekLast() {
        if(back == null) {
            throw new NullPointerException();
        }
        return back.val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node current = front;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
