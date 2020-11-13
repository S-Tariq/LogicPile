package stariq.algorithms.string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string/
// Find the first unique character in a string. Return character or index.
public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String str = "aabacdc";
        System.out.println(uniqueCharacterUsingMap(str));
        str = "aaabbbcadfcwafdq";
        System.out.println(uniqueCharacterUsingMap(str));

        str = "aabacdc";
        System.out.println(uniqueCharacterUsingArray(str));
        str = "aaabbbcadfcwafdq";
        System.out.println(uniqueCharacterUsingArray(str));

        str = "leetcode";
        System.out.println(uniqueCharacterIndex(str));
    }

    public static char uniqueCharacterUsingMap(String str) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        char unique = '\u0000';
        for(char c : str.toCharArray()) {
            if(charMap.get(c) == 1) {
                unique = c;
                break;
            }
        }
        return unique;
    }

    public static char uniqueCharacterUsingArray(String str) {
        int[] charArr = new int[26];
        for(int i = 0; i < str.length(); i++) {
            charArr[str.charAt(i) - 'a']++;
        }

        char unique = '\u0000';
        for(int i = 0; i < str.length(); i++) {
            if(charArr[str.charAt(i) - 'a'] == 1) {
                unique = str.charAt(i);
                break;
            }
        }
        return unique;
    }

    public static int uniqueCharacterIndex(String str) {
        Map<Character, Integer> map = new HashMap<>(40);
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int uniqueCharacterIndex2(String str) {
        char[] array = new char[26];
        for(char c : str.toCharArray()) {
            array[c - 'a']++;
        }
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(array[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
