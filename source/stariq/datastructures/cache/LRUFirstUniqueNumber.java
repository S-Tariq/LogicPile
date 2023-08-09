package stariq.datastructures.cache;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-number/
// Have a doubly linked list which keeps track of all the unique values.
// The most recent unique element gets added to the tail and the first unique element is at the head.

public class LRUFirstUniqueNumber {

    public static void main(String[] args) {
        LRUFirstUniqueNumber unique = new LRUFirstUniqueNumber();
        unique.add(2);
        unique.getFirstUnique(); // 2
        unique.add(2);
        unique.getFirstUnique(); // null or -1
        unique.add(3);
        unique.getFirstUnique(); // 3
        unique.add(4);
        unique.getFirstUnique(); // 3
        unique.add(3);
        unique.getFirstUnique(); // 4
    }

    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node() {

        }
    }

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> valueToNode;

    LRUFirstUniqueNumber() {
        head.next = tail;
        tail.prev = head;
        valueToNode = new HashMap<>();
    }

    public void add(int value) {
        // Check if duplicates exist
        if(valueToNode.containsKey(value)) {
            Node node = valueToNode.get(value);
            remove(node);
        } else {
            Node node = new Node(value);
            add(node);
            valueToNode.put(value, node);
        }
    }

    // First unique numbers are towards the head.
    // Recent unique numbers are added towards the tail.
    public int getFirstUnique() {
        if(head.next != tail) {
            return head.next.val;
        }
        return -1;
    }

    // Adds before tail node.
    public void add(Node node) {
        Node prevTail = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = prevTail;
        prevTail.next = node;
    }

    // Removes at any position
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
