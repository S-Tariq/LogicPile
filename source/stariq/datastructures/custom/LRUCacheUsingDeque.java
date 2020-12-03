package stariq.datastructures.custom;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
// LRU (Least Recently Used) Cache
// We use a map for constant time insertion/deletion,
// and a deque to maintain order by most recently used.
class LRUCacheUsingDeque {

    class Node {
        int key;
        int val;
    }

    private Deque<Node> deq;
    private Map<Integer, Node> nodeMap;
    private int cacheCapacity;

    public LRUCacheUsingDeque(int capacity) {
        nodeMap = new HashMap<>(capacity);
        deq = new LinkedList<>();
        cacheCapacity = capacity;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null) {
            return -1;
        }
        deq.remove(node);
        deq.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if(node != null) {
            deq.remove(node);
            node.val = value;
            deq.addFirst(node);
        } else {
            if(nodeMap.size() == cacheCapacity) {
                nodeMap.remove(deq.getLast().key);
                deq.removeLast();
            }
            node = new Node();
            node.key = key;
            node.val = value;
            nodeMap.put(node.key, node);
            deq.addFirst(node);
        }
    }
}

