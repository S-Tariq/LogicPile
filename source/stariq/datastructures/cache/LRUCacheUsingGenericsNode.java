package stariq.datastructures.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheUsingGenericsNode<K, V> {

    class Node<Ke, Va> {
        Ke key;
        Va value;
        Node<Ke, Va> prev;
        Node<Ke, Va> next;

        Node(Ke key, Va value) {
            this.key = key;
            this.value = value;
        }

        Node() {
        }
    }

    // Head and tail are dummy nodes.
    Node<K, V> head = new Node<>();
    Node<K, V> tail = new Node<>();
    Map<K, Node<K, V>> keyToNode;
    final int capacity; // Caching capacity

    LRUCacheUsingGenericsNode(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = keyToNode.get(key);
        if(node == null) {
            throw new NullPointerException();
        }
        // Removes the node and adds it to the top since it was MRU.
        remove(node);
        add(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = keyToNode.get(key);
        if(node != null) { // Node exists, remove and add to the top since MRU.
            remove(node);
            node.value = value;
            add(node);
        } else { // New node
            if(keyToNode.size() == capacity) {
                keyToNode.remove(tail.prev.key);
                remove(tail.prev);
            }
            node = new Node<>(key, value);
            keyToNode.put(key, node);
            add(node);
        }
    }

    // Removes from any position. Dummy head/tail are never passed in.
    public void remove(Node<K, V> node) {
        Node<K, V> prev = node.prev;
        Node<K, V> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Adds after head node since it is MRU.
    public void add(Node<K, V> node) {
        Node<K, V> oldHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = oldHead;
        oldHead.prev = node;
    }
}
