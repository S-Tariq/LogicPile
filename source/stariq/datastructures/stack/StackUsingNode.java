package stariq.datastructures.stack;

public class StackUsingNode {

    public static void main(String[] args) {
        StackUsingNode stack = new StackUsingNode();
        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();
        // stack.pop();

        stack.push(3);
        stack.push(4);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        stack.print2();
    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int size;

    StackUsingNode() {
        head = null;
    }

    // New elements are added as a head.
    public void push(int element) {
        Node node = new Node(element);
        node.next = head;
        head = node;
        size++;
    }

    public int pop() {
        if(head == null) {
            throw new NullPointerException();
        }
        int popped = head.val;
        head = head.next;
        size--;
        return popped;
    }

    public int peek() {
        if(head == null) {
            throw new NullPointerException();
        }
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    // Prints in stack order.
    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    // Prints in insertion order.
    public void print2() {
        printReverse(head);
    }

    private void printReverse(Node head) {
        if(head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.val + " ");
    }
}
