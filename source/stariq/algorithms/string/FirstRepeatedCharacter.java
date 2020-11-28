package stariq.algorithms.string;

import java.util.ArrayList;
import java.util.List;

// Find the first repeated character in a string.
public class FirstRepeatedCharacter {

    public static void main(String[] args) {
        char result = firstRepeatedUsingList("albksdfkarlb");
        System.out.println(result);
        result = firstRepeatedUsingList("abcal");
        System.out.println(result);
        result = firstRepeatedUsingList("tyopky");
        System.out.println(result);
        result = firstRepeatedUsingList("qwpaslkpe");
        System.out.println(result);
        System.out.println("------------");
        char result2 = firstRepeatedUsingArray("albksdfkarlb");
        System.out.println(result2);
        result2 = firstRepeatedUsingArray("abcal");
        System.out.println(result2);
        result2 = firstRepeatedUsingArray("tyopky");
        System.out.println(result2);
        result2 = firstRepeatedUsingArray("qwpaslkpe");
        System.out.println(result2);
    }

    public static char firstRepeatedUsingList(String str) {

        List<Character> allChars = new ArrayList<>();
        char c = str.charAt(0);
        for(int i = 1; i < str.length(); i++) {
            if(!allChars.contains(c)) {
                allChars.add(c);
            } else {
                break;
            }
            c = str.charAt(i);
        }
        return c;

    }

    public static char firstRepeatedUsingArray(String str) {

        int[] array = new int[26];
        char c = str.charAt(0);
        for(int i = 1; i < str.length(); i++) {
            // Can use 'a' or 97
            array[c - 'a'] += 1;
            if(array[c - 'a'] > 1) {
                break;
            }
            c = str.charAt(i);
        }
        return c;
    }

}
