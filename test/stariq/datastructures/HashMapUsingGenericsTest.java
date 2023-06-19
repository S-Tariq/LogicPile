package stariq.datastructures;

import stariq.datastructures.hashmap.HashMapUsingGenerics;

public class HashMapUsingGenericsTest {
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
}
