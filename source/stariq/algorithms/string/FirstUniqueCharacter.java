package stariq.algorithms.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Find the first unique character in a string.
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

}
