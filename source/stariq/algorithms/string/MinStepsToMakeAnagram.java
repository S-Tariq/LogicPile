package stariq.algorithms.string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
public class MinStepsToMakeAnagram {

    public int minSteps(String s, String t) {
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        int count = 0;
        for(int i : array) {
            if(i > 0) {
                count += i;
            }
        }
        return count;
    }

    // Time exceeds but the logic works for non-lower non-alphabetic characters.
    public int minSteps2(String s, String t) {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        for(int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            list.remove(c);

        }
        return list.size();
    }

    public int minSteps3(String s, String t) {
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        int count = 0;
        for(int i : array) {
            if(i != 0) {
                count += Math.abs(i);
            }
        }
        return count / 2;
    }
}
