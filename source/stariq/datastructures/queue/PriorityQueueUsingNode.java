package stariq.datastructures.queue;

public class PriorityQueueUsingNode {

    public static void main(String[] args) {
        PriorityQueueUsingNode queue = new PriorityQueueUsingNode();
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);
        queue.offer(1);
        queue.offer(0);
        queue.offer(6);

        queue.poll();

        System.out.println("First element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.print();
    }

    class Node {
        int val;
        Node next;
    }

    Node front;
    int size;

    public void offer(int element) {
        Node temp = new Node();
        temp.val = element;
        if(front == null || element < front.val) {
            temp.next = front;
            front = temp;
        } else {
            Node current = front;
            while(current.next != null && current.next.val <= element) {
                current = current.next;
            }
            temp.next = current.next;
            current.next = temp;
        }
        size++;
    }

    public int poll() {
        if(front == null) {
            throw new NullPointerException();
        }
        int polled = front.val;
        front = front.next;
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
