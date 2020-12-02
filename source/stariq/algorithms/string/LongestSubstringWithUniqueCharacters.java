package stariq.algorithms.string;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithUniqueCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("asjrgapa"));
    }

    public static int lengthOfLongestSubstring(String str) {
        // i is the slow pointer, j is the fast pointer.
        int max = 0;
        int j = 0;
        int i = 0;
        Set<Character> uniqueChars = new HashSet<>();
        while(i < str.length()) {
            char c = str.charAt(i);
            if(uniqueChars.contains(c)) {
                uniqueChars.remove(str.charAt(j));
                j++;
            } else {
                uniqueChars.add(c);
                max = Math.max(uniqueChars.size(), max);
                i++;
            }
        }
        return max;
    }

    // Works but can be improved using a while loop instead so j is not decrementing inside the loop.
    public static int lengthOfLongestSubstring2(String str) {
        // i is the slow pointer, j is the fast pointer.
        int max = 0;
        int i = 0;
        Set<Character> uniqueChars = new HashSet<>();
        for(int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            if(uniqueChars.contains(c)) {
                uniqueChars.remove(str.charAt(i));
                i++;
                j--;
            } else {
                uniqueChars.add(c);
                max = Math.max(uniqueChars.size(), max);
            }
        }
        return max;
    }

    // Works but time exceeded.
    public static int lengthOfLongestSubstring2Loops(String str) {
        int max = 0;
        for(int i = 0; i < str.length(); i++) {
            Set<Character> uniqueChars = new HashSet<>();
            for(int j = i; j < str.length(); j++) {
                char c = str.charAt(j);
                if(uniqueChars.contains(c)) {
                    uniqueChars = new HashSet<>();
                    j--;
                } else {
                    uniqueChars.add(c);
                }
                max = Math.max(uniqueChars.size(), max);
            }
        }
        return max;
    }
}
