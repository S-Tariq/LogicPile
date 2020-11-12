package stariq.datastructures.custom;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
// LRU (Least Recently Used) Cache
class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    private final Node head = new Node();
    private final Node tail = new Node();
    private Map<Integer, Node> nodeMap;
    private final int cacheCapacity;

    public LRUCache(int capacity) {
        nodeMap = new HashMap<>(capacity);
        cacheCapacity = capacity;
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
            if(nodeMap.size() == cacheCapacity) { // Full capacity
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            node = new Node();
            node.key = key;
            node.val = value;
            nodeMap.put(node.key, node);
            add(node);
        }
    }

    private void add(Node node) {
        Node nextHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextHead;
        nextHead.prev = node;
    }

    // Assumes that head or tail are never passed in.
    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
