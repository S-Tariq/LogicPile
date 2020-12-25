package stariq.datastructures.hashmap;

public class HashMapUsingGenerics<K,V> {

    public static void main(String[] args) {
        HashMapUsingGenerics<String, Integer> map = new HashMapUsingGenerics<>();
        map.put("Bob", 1);
        map.put("Bob", 2);
        map.put("John", 1);
        map.put("Ann", 3);
        System.out.println(map.get("Bob"));
        map.remove("Bob");
  //      System.out.println(map.get("Bob"));
        System.out.println(map.contains("John"));
        System.out.println(map.contains("Bob"));

//        MyHashMap<String, String> map2 = new MyHashMap<>();
//        map2.put("Bob", "Go");
//        map2.put("Bob", "Bobby");
//        map2.put("John", "Johnny");
//        System.out.println(map2.get("Bob"));
//        System.out.println(map2.remove("Jo"));
//        System.out.println(map2.contains("Bob"));
    }

    static class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Things to implement: bucket, generics, load factor, capacity, collision, traversal
    Node<K,V>[] buckets;
    int capacity;
    double loadFactor = 0.75;

    @SuppressWarnings({"unchecked"})
    HashMapUsingGenerics() {
        buckets = (Node<K,V>[]) new Node[3];
    }

    public void put(K key, V value) {
        put(key, value, buckets);
    }

    private void put(K key, V value, Node<K,V>[] buckets) {
        int hash = key.hashCode();
        int index = hash % buckets.length;
        if(buckets[index] == null) {
            capacity++;
            buckets[index] = new Node<>(key, value);
            // Capacity has exceeded 75 percent of the bucket size.
            if(capacity > buckets.length * loadFactor) {
                resizeBucket();
            }
        } else {
            Node<K,V> node = buckets[index];
            Node<K,V> prev = node;
            while(node != null) {
                if(node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node<>(key, value);
        }
    }

    @SuppressWarnings({"unchecked"})
    private void resizeBucket() {
        Node<K,V>[] biggerBucket = (Node<K,V>[]) new Node[buckets.length * 2];
        capacity = 0;
        for(Node<K,V> n : buckets) {
            if(n == null) {
                continue;
            }
            put(n.key, n.value, biggerBucket);
        }
        buckets = biggerBucket;
    }

    public V get(K key) {
        Node<K,V> node = buckets[getIndex(key)];
        while(node != null) {
            if(node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        throw new RuntimeException(key + " does not exist");
    }

    public boolean contains(K key) {
        Node<K,V> node = buckets[getIndex(key)];
        while(node != null) {
            if(node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean remove(K key) {
        Node<K,V> node = buckets[getIndex(key)];
        Node<K,V> prev = null;
        while(node != null) {
            if(node.key.equals(key)) {
                if(prev == null) {
                    buckets[getIndex(key)] = null;
                    capacity--;
                } else {
                    prev.next = node.next;
                }
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        int index = hash % buckets.length;
        return index;
    }
}
