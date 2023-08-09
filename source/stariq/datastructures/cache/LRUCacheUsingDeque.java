package stariq.datastructures.cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
// LRU - Least Recently Used
// We use a map for constant time insertion/deletion,
// and a deque to maintain order by most recently used.
// Potentially worse time complexity since remove() is O(n).

class LRUCacheUsingDeque {

    class Node {
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Deque<Node> deque;
    private Map<Integer, Node> nodeMap;
    private int cacheCapacity;

    public LRUCacheUsingDeque(int capacity) {
        nodeMap = new HashMap<>(capacity);
        deque = new LinkedList<>();
        cacheCapacity = capacity;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null) {
            throw new NullPointerException();
        }
        deque.remove(node);
        deque.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if(node != null) {
            deque.remove(node);
            node.val = value;
            deque.addFirst(node);
        } else {
            if(nodeMap.size() == cacheCapacity) {
                nodeMap.remove(deque.getLast().key);
                deque.removeLast();
            }
            node = new Node(key,value);
            nodeMap.put(key, node);
            deque.addFirst(node);
        }
    }
}

