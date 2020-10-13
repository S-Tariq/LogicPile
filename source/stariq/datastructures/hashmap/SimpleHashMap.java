package stariq.datastructures.hashmap;

import java.util.Arrays;

// This hashmap has integer has key.
// Key ranges from 0-100.
// Value is -1 for undefined key.
public class SimpleHashMap {

    int[] array;

    public SimpleHashMap() {
        array = new int[100];
        Arrays.fill(array, -1);
    }

    public void put(int key, int value) {
        array[key] = value;
    }

    public int get(int key) {
        return array[key];
    }

    public void remove(int key) {
        array[key] = -1;
    }

}
