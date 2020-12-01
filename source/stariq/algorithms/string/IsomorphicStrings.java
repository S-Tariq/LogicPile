package stariq.algorithms.string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphicUsingMap("egg", "add"));
        System.out.println(isIsomorphicUsingMap("tee", "er"));
        System.out.println(isIsomorphicUsingArray("foo", "bar"));
        System.out.println(isIsomorphicUsingArray("paper","title"));
    }

    public static boolean isIsomorphicUsingMap(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(Integer i = 0; i < s.length(); i++) {
            Integer sValue = sMap.put(s.charAt(i), i);
            Integer tValue = tMap.put(t.charAt(i), i);
            if(sValue != tValue) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphicUsingArray(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] sArr = new int[127];
        int[] tArr = new int[127];
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(sArr[c1] != tArr[c2]) {
                return false;
            }
            // Default value for array is 0.
            // i + 1 ensures that for the first loop, the value is reassigned as 1.
            sArr[c1] = i + 1;
            tArr[c2] = i + 1;
        }
        return true;
    }
}
