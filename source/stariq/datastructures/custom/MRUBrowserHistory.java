package stariq.datastructures.custom;

import java.util.HashMap;
import java.util.Map;

// MRU - Most Recently Used
public class MRUBrowserHistory {

    public static void main(String[] args) {
        MRUBrowserHistory browser = new MRUBrowserHistory();
        browser.visit("bloom");
        browser.visit("bbc");
        browser.visit("cnn");
        browser.visit("bbc");
        browser.printHistory();
    }

    class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
        }

        Node() {

        }
    }

    Node head = new Node();
    Node tail = new Node();
    Map<String, Node> map;

    MRUBrowserHistory() {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public void visit(String url) {
        Node node = map.get(url);
        if(node != null) {
            remove(node);
            add(node);
        } else {
            node = new Node(url);
            map.put(url, node);
            add(node);
        }
    }

    public void add(Node node) {
        Node nextHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextHead;
        nextHead.prev = node;
    }

    public void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void printHistory() {
        Node current = head.next;
        while(current.next != null) {
            System.out.println(current.url);
            current = current.next;
        }
    }
}
