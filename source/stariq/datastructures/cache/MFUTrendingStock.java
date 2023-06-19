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
        System.out.println(ts.getTrendingStock());
    }

    class Node {
        String value;
        int count;
        Node prev;
        Node next;

        Node(String value) {
            this.value = value;
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
    Map<String, Node> nodeMap;
    // Frequency to Doubly list of Nodes
    Map<Integer, DoublyList> countMap;
    int mostCount;

    MFUTrendingStock() {
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public void processStock(String stock) {
        Node node = nodeMap.get(stock);
        if(node == null) {
            node = new Node(stock);
            nodeMap.put(stock, node);
        } else {
            DoublyList oldList = countMap.get(node.count);
            oldList.remove(node);
            if(oldList.size == 0) {
                countMap.remove(node.count);
            }
            node.count++;
        }
        DoublyList list = countMap.get(node.count);
        if(list == null) {
            list = new DoublyList();
            countMap.put(node.count, list);
        }
        list.add(node);
        mostCount = Math.max(mostCount, node.count);
    }

    public String getTrendingStock() {
        DoublyList list = countMap.get(mostCount);
        Node node = list.pollFirst();
        if(list.size == 0) {
            countMap.remove(mostCount);
        }
        nodeMap.remove(node.value);
//        while(countMap.get(mostCount) == null && mostCount >= 0) {
//            mostCount--;
//        }
        mostCount = 0;
        for(Integer i : countMap.keySet()) {
            mostCount = Math.max(mostCount, i);
        }
        return node.value;
    }
}
