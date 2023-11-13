package stariq.rough;

import java.util.HashMap;
import java.util.Map;

public class Rough {
}

class MFUCache {

    class Node {
        String stock;
        int count;
        Node prev;
        Node next;

        Node(String stock) {
            this.stock = stock;
            count = 1;
        }

        Node() {

        }
    }

    class DoublyList {

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

        // Add to the head
        public void add(Node node) {
            Node tempNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = tempNode;
            tempNode.prev = node;
            size++;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        public Node pollFirst() {
            if(size == 0) return null;
            Node tempNode = head.next;
            remove(tempNode);
            return tempNode;
        }
    }

    int mostCount;
    Map<String, Node> stockToNode;
    Map<Integer, DoublyList> countToList;

    MFUCache() {
        mostCount = 0;
        stockToNode = new HashMap<>();
        countToList = new HashMap<>();
    }

    // Adds stock
    public void processStock(String stock) {
        Node node = stockToNode.get(stock);
        if(node != null) {
            DoublyList oldList = countToList.get(node.count);
            oldList.remove(node);
            if(oldList.size == 0) {
                countToList.remove(node.count);
            }
            node.count++;
        } else {
            node = new Node(stock);
            stockToNode.put(stock, node);
        }
        DoublyList newList = countToList.get(node.count);
        if(newList == null) {
            newList = new DoublyList();
        }
        newList.add(node);
        countToList.put(node.count, newList);
    }

    // Returns the most frequent stock and removes it.
    public String getTrendingStock() {
        if(mostCount == 0) {
            throw new NullPointerException();
        }
        DoublyList list = countToList.get(mostCount);
        Node node = list.pollFirst();
        if(list.size == 0) {
            countToList.remove(mostCount);
        }
        stockToNode.remove(node.stock);

        while(countToList.get(mostCount) == null  && mostCount <= 0) {
            mostCount--;
        }

        return node.stock;
    }




}













