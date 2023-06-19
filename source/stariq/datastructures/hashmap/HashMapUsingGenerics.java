package stariq.datastructures.hashmap;

/*
Hashmap best and average case for put, get and remove is O(1) and worst case is O(n).

- Put, Get & Remove:
The put(), get() and remove() time complexity is O(1)
with the assumption that key-value pairs are well distributed across the buckets.
This happens when the hashcode() implementation is good.
If the hashcode() is poorly written where all key-value pairs end up in the same bucket,
the put(), get() and remove() time complexity becomes O(n).
This is because the methods need to iterate through a linked list which contains all the pairs.

- Put:
The put() method that causes a resize (rehashing) takes O(n) time.
However, that happens on O(1/n) of all insertions, so the average time is amortized O(1).

- Contains key:
The containsKey() takes O(1) as it is just a get() method that does not return a value
but a boolean of whether the key is present in the map.
If we are using a bad hashcode() function, then worse case is O(n).

- Contains value:
The containsValue() takes O(n) because without the key,
the index is unknown and it needs to iterate over all the values stored in the map.
 */

public class HashMapUsingGenerics<K,V> {

    class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    Node<K,V>[] buckets;
    int capacity;
    double loadFactor = 0.75;

    @SuppressWarnings({"unchecked"})
    public HashMapUsingGenerics() {
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
            Node<K,V> prev = null;
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
