package stariq.datastructures.custom;

import java.util.HashMap;
import java.util.Map;

// Question in data
// https://leetcode.com/problems/first-unique-number/

public class FirstUniqueNumberLRU {

    public static void main(String[] args) {
        FirstUniqueNumberLRU unique = new FirstUniqueNumberLRU();
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
    Map<Integer, Node> map;

    FirstUniqueNumberLRU() {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public void add(int value) {
        if(map.containsKey(value)) {
            Node node = map.get(value);
            remove(node);
        } else {
            Node node = new Node(value);
            add(node);
            map.put(value, node);
        }
    }

    // First unique numbers are towards the head.
    // Recent unique numbers are added towards the tail.
    public int getFirstUnique() {
        if(head.next != tail) {
            return head.next.val;
        }
        // throw new NullPointerException();
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
