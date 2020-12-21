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
    }

    Node top;
    int size;

    StackUsingNode() {
        top = null;
    }

    // New elements are added as a head.
    public void push(int element) {
        Node temp = new Node();
        temp.val = element;
        temp.next = top;
        top = temp;
        size++;
    }

    public int pop() {
        if(top == null) {
            throw new NullPointerException();
        }
        int popped = top.val;
        top = top.next;
        size--;
        return popped;
    }

    public int peek() {
        if(top == null) {
            throw new NullPointerException();
        }
        return top.val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    // Prints in stack order.
    public void print() {
        Node temp = top;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    // Prints in insertion order.
    public void print2() {
        printReverse(top);
    }

    private void printReverse(Node head) {
        if(head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.val + " ");
    }
}
