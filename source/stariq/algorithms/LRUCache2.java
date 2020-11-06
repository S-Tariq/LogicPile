package stariq.algorithms;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache2 {

    class Node {
        int key;
        int val;
    }

    private Deque<Node> deq;
    private Map<Integer, Node> nodeMap;
    private int cacheCapacity;

    public LRUCache2(int capacity) {
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
