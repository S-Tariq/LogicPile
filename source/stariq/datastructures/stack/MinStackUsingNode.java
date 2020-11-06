package stariq.datastructures.stack;

public class MinStackUsingNode {

    class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Node head;

    public MinStackUsingNode() {

    }

    public void push(int val) {
        if(head == null) {
            head = new Node(val, val);
        } else {
            int min = Math.min(val, head.min);
            Node newNode = new Node(val, min);
            newNode.next = head;
            head = newNode;
        }
    }

    public void pop() {
        if(head != null) {
            head = head.next;
        }
    }

    public int top() {
        if(head != null) {
            return head.val;
        }
        return -1;
    }

    public int getMin() {
        if(head != null) {
            return head.min;
        }
        return -1;
    }
}
