package stariq.datastructures.design;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lfu-cache/
// Visualization:
// https://leetcode.com/problems/lfu-cache/discuss/443113/Visualization-for-2-HashMap-and-1-DoubleLinkedList-approach-
// LFU - Least Frequency Used
public class LFUCache {

    class Node {
        int key;
        int val;
        int count;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            count = 1;
        }

        Node() {

        }
    }

    class DoublyList {
        final Node head = new Node();
        final Node tail = new Node();
        int size;

        DoublyList() {
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            Node nextHead = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextHead;
            nextHead.prev = node;
            size++;
        }

        public void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        public Node pollLast() {
            if(size == 0) {
                return null;
            }
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    // Key to Node (Key, Value)
    Map<Integer, Node> nodeMap;
    // Frequency to Doubly list of Nodes (Key, Value)
    Map<Integer, DoublyList> countMap;
    int capacity;
    int leastCount;

    LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null) {
            return -1;
        }
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }
        Node node = nodeMap.get(key);
        if(node != null) {
            node.val = value;
            update(node);
        } else {
            if(nodeMap.size() == capacity) {
                DoublyList lastList = countMap.get(leastCount);
                nodeMap.remove(lastList.pollLast().key);
            }
            node = new Node(key, value);
            nodeMap.put(key, node);
            leastCount = 1;
            DoublyList newList = countMap.getOrDefault(node.count, new DoublyList());
            newList.add(node);
            countMap.put(node.count, newList);
        }
    }

    public void update(Node node) {
        DoublyList oldList = countMap.get(node.count);
        oldList.remove(node);
        if(node.count == leastCount && oldList.size == 0) {
            leastCount++;
        }
        node.count++;
        DoublyList newList = countMap.getOrDefault(node.count, new DoublyList());
        newList.add(node);
        countMap.put(node.count, newList);
    }
}
