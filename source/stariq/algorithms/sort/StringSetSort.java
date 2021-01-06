package stariq.algorithms.sort;

import java.util.*;

public class StringSetSort {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("apple");
        set.add("help");
        set.add("ant");
        set.add("orange");
        set.add("lemon");
        for(String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
        sortUsingTreeSet(set);
        System.out.println();
        sortUsingCollection(set);
    }

    public static void sortUsingTreeSet(Set<String> set) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(set);
        for(String s : treeSet) {
            System.out.print(s + " ");
        }
    }

    public static void sortUsingCollection(Set<String> set) {
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(String s : list) {
            System.out.print(s + " ");
        }
    }
}
