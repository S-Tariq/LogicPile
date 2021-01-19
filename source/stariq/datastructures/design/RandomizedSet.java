package stariq.datastructures.design;

import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class RandomizedSet {

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
        rs.remove(2);
        rs.insert(2);
        System.out.println(rs.getRandom());
        rs.remove(1);
        rs.insert(2);
        System.out.println(rs.getRandom());
    }

    Map<Integer, Integer> valToIndex = new HashMap<>();
    List<Integer> values = new ArrayList<>();
    java.util.Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        // Cannot have duplicates as it is a set.
        if(valToIndex.containsKey(val)) {
            return false;
        }
        values.add(val);
        valToIndex.put(val, values.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        if(index < values.size() - 1) {
            // Set the last value to be at the index that needs to be removed.
            int last = values.get(values.size() - 1);
            values.set(index, last);
            valToIndex.put(last, index);
        }
        // Remove the last element. This allows for O(1) removal.
        values.remove(values.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int randIndex = random.nextInt(values.size());
        return values.get(randIndex);
    }
}
