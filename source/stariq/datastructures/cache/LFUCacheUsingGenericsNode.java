package stariq.datastructures.cache;

import java.util.HashMap;
import java.util.Map;

public class LFUCacheUsingGenericsNode<K, V> {

    class Node<Ke, Va> {
        Ke key;
        Va value;
        int freq;
        Node<Ke, Va> prev;
        Node<Ke, Va> next;

        Node(Ke key, Va value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }

        Node() {

        }
    }

    class DoublyLinkedList<Ke, Va> {
        Node<Ke, Va> head;
        Node<Ke, Va> tail;
        int size;

        DoublyLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        // Add after head
        public void add(Node<Ke, Va> node) {
            Node<Ke, Va> tempNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = tempNode;
            tempNode.prev = node;
            size++;
        }

        public void remove(Node<Ke, Va> node) {
            Node<Ke, Va> prevNode = node.prev;
            Node<Ke, Va> nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        // This is used to remove/return last element.
        public Node<Ke, Va> pollLast() {
            if(size == 0) return null;
            Node<Ke, Va> lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }
    }

    // Key to Node map
    Map<K, Node<K, V>> keyToNode;
    // Frequency to DoublyLinkedList map
    Map<Integer, DoublyLinkedList<K, V>> freqToList;
    int capacity;
    int leastFreq;

    LFUCacheUsingGenericsNode(int capacity) {
        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
        this.capacity = capacity;
        this.leastFreq = 0;
    }

    public V get(K key) {
        Node<K, V> node = keyToNode.get(key);
        if(node == null) {
            throw new NullPointerException();
        }
        update(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = keyToNode.get(key);
        if(node == null) {
            if(keyToNode.size() == capacity) {
                DoublyLinkedList<K, V> leastFreqList = freqToList.get(leastFreq);
                keyToNode.remove(leastFreqList.pollLast().key);
            }
            node = new Node<>(key, value);
            DoublyLinkedList<K, V> list = freqToList.get(node.freq);
            if(list == null) {
                list = new DoublyLinkedList<>();
            }
            list.add(node);
            leastFreq = node.freq;
            keyToNode.put(key, node);
            freqToList.put(node.freq, list);
        } else {
            node.value = value;
            update(node);
        }
    }

    public void update(Node<K, V> node) {
        DoublyLinkedList<K, V> oldList = freqToList.get(node.freq);
        oldList.remove(node);
        if(node.freq == leastFreq && oldList.size == 0) {
            freqToList.remove(leastFreq);
            leastFreq++;
        }
        node.freq++;
        DoublyLinkedList<K, V> newList = freqToList.get(node.freq);
        if(newList == null) {
            newList = new DoublyLinkedList<>();
        }
        newList.add(node);
        freqToList.put(node.freq, newList);
    }
}

