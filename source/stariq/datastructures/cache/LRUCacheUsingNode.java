package stariq.datastructures.cache;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
// LRU - Least Recently Used
// We use a map for constant time insertion/deletion,
// and a list to maintain order by most recently used.

class LRUCacheUsingNode {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node() {

        }
    }

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> nodeMap;
    final int capacity;

    public LRUCacheUsingNode(int capacity) {
        nodeMap = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null) {
            return -1;
        }
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if(node != null) { // Node exists - MRU
            remove(node);
            node.val = value;
            add(node);
        } else { // New node
            // Assume capacity is > 0
            if(nodeMap.size() == capacity) { // Full capacity
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            node = new Node(key, value);
            nodeMap.put(node.key, node);
            add(node);
        }
    }

    // Adds after head node.
    private void add(Node node) {
        Node nextHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextHead;
        nextHead.prev = node;
    }

    // Assumes that head or tail are never passed in.
    // Removes from any position.
    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
