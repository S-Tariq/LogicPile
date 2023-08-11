package stariq.datastructures.cache;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/discuss/interview-question/627139/Bloomberg-or-Onsite-or-Trending-Stock
public class MFUTrendingStock {

    public static void main(String[] args) {
        MFUTrendingStock ts = new MFUTrendingStock();
        ts.processStock("TSLA");
        ts.processStock("APPL");
        ts.processStock("TSLA");
        System.out.println(ts.getTrendingStock());
        ts.processStock("APPL");
        ts.processStock("NTFX");
        ts.processStock("TSLA");
        ts.processStock("BBRG");
        System.out.println(ts.getTrendingStock());
        System.out.println(ts.getTrendingStock());
        System.out.println(ts.getTrendingStock());
        System.out.println(ts.getTrendingStock());
//        System.out.println(ts.getTrendingStock()); // Throws null pointer exception since no stocks left.
    }

    class Node {
        String stock;
        int freq;
        Node prev;
        Node next;

        Node(String value) {
            this.stock = value;
            freq = 1;
        }

        Node() {

        }
    }

    class DoublyList {
        // These nodes can be made final to stop values being added to it.
        // Making it final means it needs to be initialised as a static field/not in a constructor.
        Node head;
        Node tail;
        int size;

        DoublyList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void add(Node node) {
            Node tempNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = tempNode;
            tempNode.prev = node;
            size++;
        }

        public void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        public Node pollFirst() {
            if(size == 0) {
                return null;
            }
            Node node = head.next;
            remove(node);
            return node;
        }
    }

    // Stock to Node
    Map<String, Node> stockToNode;
    // Frequency to Doubly list of Nodes
    Map<Integer, DoublyList> freqToList;
    int mostFreq;

    MFUTrendingStock() {
        stockToNode = new HashMap<>();
        freqToList = new HashMap<>();
        mostFreq = 0;
    }

    // Adds stock to the cache
    public void processStock(String stock) {
        Node node = stockToNode.get(stock);
        if(node == null) {
            node = new Node(stock);
            stockToNode.put(stock, node);
        } else {
            DoublyList oldList = freqToList.get(node.freq);
            oldList.remove(node);
            if(oldList.size == 0) {
                freqToList.remove(node.freq);
            }
            node.freq++;
        }
        DoublyList list = freqToList.get(node.freq);
        if(list == null) {
            list = new DoublyList();
        }
        list.add(node);
        freqToList.put(node.freq, list);
        // Assigns the most frequent value
        mostFreq = Math.max(mostFreq, node.freq);
    }

    public String getTrendingStock() {
        if(mostFreq == 0) {
            throw new NullPointerException();
        }
        DoublyList list = freqToList.get(mostFreq);
        Node node = list.pollFirst();
        if(list.size == 0) {
            freqToList.remove(mostFreq);
        }
        stockToNode.remove(node.stock);

        // Decides the new most count stock after removing the old most count stock.
        while(freqToList.get(mostFreq) == null && mostFreq >= 0) {
            mostFreq--;
        }
        // Another way of assigning mostFreq value:
//        mostCount = 0;
//        for(Integer i : countMap.keySet()) {
//            mostCount = Math.max(mostCount, i);
//        }
        return node.stock;
    }
}
