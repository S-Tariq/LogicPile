package stariq.datastructures.queue;

public class QueueUsingNode {

    public static void main(String[] args) {
        QueueUsingNode queue = new QueueUsingNode();
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);

        queue.poll();

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.print();
    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node front;
    Node back;
    int size;

    QueueUsingNode() {
        front = null;
        back = null;
    }

    public void offer(int element) {
        Node node = new Node(element);
        // First node to be added.
        if(back == null) {
            front = node;
            back = node;
        } else {
            back.next = node;
            back = node;
        }
        size++;
    }

    public int poll() {
        if(front == null) {
            throw new NullPointerException();
        }
        int polled = front.val;
        front = front.next;
        if(front == null) {
            back = null;
        }
        size--;
        return polled;
    }

    public int peek() {
        if(front == null) {
            throw new NullPointerException();
        }
        return front.val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node temp = front;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
